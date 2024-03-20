"use strict";
function showAlert(message) {
    alert(message);
}
function showDiv(id) {
    hideAllDiv();
    const divToShow = document.getElementById(id);
    if (divToShow) {
        divToShow.style.display = 'flex';
    }
}
function hideAllDiv() {
    const allDiv = document.querySelectorAll('.hidden-div');
    allDiv.forEach((div) => {
        const hiddenDiv = div;
        hiddenDiv.style.display = 'none';
    });
}
function clearHTML(container) {
    container.innerHTML = '';
}
function clearInputField() {
    const inputElements = document.querySelectorAll('input');
    inputElements.forEach((input) => {
        if (!document.getElementById('skillsContainer') || !document.getElementById('skillsContainer2')) {
            input.value = '';
        }
    });
}
document.addEventListener('DOMContentLoaded', () => {
    const btnGenerateChart = document.querySelector('#btnSkillChart');
    if (btnGenerateChart) {
        btnGenerateChart.addEventListener('click', () => {
            generateChart(applicantList);
        });
    }
});
function generateChart(applicantList) {
    const labels = skillType;
    const count = labels.map(skill => applicantList.filter(applicant => applicant.skills.includes(skill)).length);
    const context = document.getElementById('skillsChart');
    if (context) {
        if (skillsChart) {
            skillsChart.destroy();
        }
        const data = {
            labels: labels,
            datasets: [{
                    label: 'Skills dos Candidatos',
                    data: count,
                    legend: {
                        labels: {
                            color: 'black',
                        },
                    },
                }],
        };
        skillsChart = new Chart(context, {
            type: 'bar',
            data: data,
        });
    }
    ;
}
