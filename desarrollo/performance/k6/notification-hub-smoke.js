import http from 'k6/http';
import { check, sleep } from 'k6';

const baseUrl = __ENV.BASE_URL || 'http://localhost:8083';

function uuidFromIteration(prefix) {
  const suffix = String((__VU * 1000000) + __ITER).padStart(12, '0');
  return `00000000-0000-4000-${prefix}-${suffix}`;
}

export const options = {
  vus: 5,
  duration: '30s',
  thresholds: {
    http_req_failed: ['rate<0.01'],
    http_req_duration: ['p(95)<500'],
  },
};

export default function () {
  const eventId = uuidFromIteration('8000');
  const params = {
    headers: {
      'Content-Type': 'application/json',
      'X-Correlation-Id': `k6-notifications-${__VU}-${__ITER}`,
    },
  };

  const eventPayload = JSON.stringify({
    eventId,
    type: 'ticket.created',
    recipient: `customer-${__VU}-${__ITER}@example.com`,
    payload: JSON.stringify({
      ticketId: uuidFromIteration('9000'),
      priority: 'HIGH',
    }),
    occurredAt: new Date().toISOString(),
  });

  const processResponse = http.post(`${baseUrl}/api/events/notifications`, eventPayload, params);
  check(processResponse, {
    'notification event accepted': (res) => res.status === 200,
    'processing result returned': (res) => Boolean(res.body),
  });

  const snapshotResponse = http.get(`${baseUrl}/api/notifications/operations/snapshot`, {
    headers: {
      'X-Correlation-Id': `k6-notifications-snapshot-${__VU}-${__ITER}`,
    },
  });
  check(snapshotResponse, {
    'operations snapshot available': (res) => res.status === 200,
  });

  sleep(1);
}
