import http from 'k6/http';
import { check, sleep } from 'k6';

const baseUrl = __ENV.BASE_URL || 'http://localhost:8080';
const bearerToken = __ENV.TOKEN || '';

export const options = {
  vus: 3,
  duration: '30s',
  thresholds: {
    http_req_failed: ['rate<0.05'],
    http_req_duration: ['p(95)<800'],
  },
};

export default function () {
  const params = {
    headers: {
      'Content-Type': 'application/json',
      'X-Client-Id': __ENV.CLIENT_ID || 'k6-local',
      'X-Correlation-Id': `k6-gateway-${__VU}-${__ITER}`,
      ...(bearerToken ? { Authorization: `Bearer ${bearerToken}` } : {}),
    },
  };

  const customerPayload = JSON.stringify({
    documentNumber: `GW-${__VU}-${__ITER}`,
    fullName: 'Gateway Smoke User',
    email: `gateway-${__VU}-${__ITER}@example.com`,
  });

  const response = http.post(`${baseUrl}/support/api/customers`, customerPayload, params);

  check(response, {
    'gateway authorized or protected': (res) => [201, 401, 403, 429].includes(res.status),
    'token provided reaches service': (res) => !bearerToken || [201, 429].includes(res.status),
  });

  sleep(1);
}
