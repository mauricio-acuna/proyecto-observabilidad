const rows = document.getElementById("projectRows");
const coverageList = document.getElementById("coverageList");
const sprintTimeline = document.getElementById("sprintTimeline");

window.dashboardData.projects.forEach((project) => {
  const row = document.createElement("tr");
  row.innerHTML = `
    <td><strong>${project.name}</strong></td>
    <td><span class="tag tag-green">${project.status}</span></td>
    <td>${project.demonstrates}</td>
    <td>${project.next}</td>
  `;
  rows.appendChild(row);
});

window.dashboardData.coverage.forEach(([name, value]) => {
  const item = document.createElement("article");
  item.className = "coverage-item";
  item.innerHTML = `
    <strong>${name}</strong>
    <div class="bar" aria-label="${name}: ${value}%">
      <span style="width: ${value}%"></span>
    </div>
  `;
  coverageList.appendChild(item);
});

window.dashboardData.sprints.forEach(([name, detail]) => {
  const item = document.createElement("article");
  item.className = "sprint";
  item.innerHTML = `
    <strong>${name}</strong>
    <p>${detail}</p>
    <span class="tag tag-blue">Planificado</span>
  `;
  sprintTimeline.appendChild(item);
});

