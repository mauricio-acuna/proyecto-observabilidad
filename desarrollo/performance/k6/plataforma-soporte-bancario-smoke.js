import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  vus: 5,
  duration: '30s',
  thresholds: {
    http_req_failed: ['rate<0.01'],
    http_req_duration: ['p(95)<500'],
  },
};

export default function () {
  const customerPayload = JSON.stringify({
    documentNumber: `DOC-${__VU}-${__ITER}`,
    fullName: 'Mauricio Acuna',
    email: `mauricio-${__VU}-${__ITER}@example.com`,
  });

  const params = {
    headers: {
      'Content-Type': 'application/json',
      'X-Correlation-Id': `k6-${__VU}-${__ITER}`,
    },
  };

  const customerResponse = http.post('http://localhost:8080/api/customers', customerPayload, params);
  check(customerResponse, {
    'customer created': (res) => res.status === 201,
  });

  if (customerResponse.status === 201) {
    const customer = customerResponse.json();
    const ticketPayload = JSON.stringify({
      customerId: customer.id,
      subject: 'Card blocked',
      description: 'Customer card was blocked during payment',
      priority: 'HIGH',
    });

    const ticketResponse = http.post('http://localhost:8080/api/tickets', ticketPayload, params);
    check(ticketResponse, {
      'ticket created': (res) => res.status === 201,
    });
  }

  sleep(1);
}
