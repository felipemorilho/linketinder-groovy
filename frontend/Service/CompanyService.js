"use strict";
var _a;
const companyList = [];
fillSkillsOptions('skillsContainer2');
const inputCompany = document.getElementById('companyName');
const showCompany = document.getElementById('showCompanyProfile');
const applicantRegistered = document.getElementById('applicantRegistered');
const btnDeleteCompany = document.getElementById('btnDeleteCompany');
(_a = document.getElementById('btnShowCompany')) === null || _a === void 0 ? void 0 : _a.addEventListener('click', () => {
    clearHTML(applicantRegistered);
});
function registerCompany() {
    const nameInput = document.getElementById("nameCompany").value;
    const emailInput = document.getElementById("emailCompany").value;
    const cnpjInput = document.getElementById("cnpjCompany").value;
    const stateInput = document.getElementById("stateCompany").value;
    const countryInput = document.getElementById("countryCompany").value;
    const cepInput = document.getElementById("cepCompany").value;
    const descriptionInput = document.getElementById("descriptionCompany").value;
    const companyName = validateRegex(textRegex, nameInput, "Nome");
    const companyEmail = validateRegex(emailRegex, emailInput, "Email");
    const companyCnpj = validateRegex(cnpjRegex, cnpjInput, "CNPJ");
    const companyState = validateRegex(textRegex, stateInput, "Estado");
    const companyCountry = validateRegex(textRegex, countryInput, "País");
    const companyCep = validateRegex(cepRegex, cepInput, "CEP");
    const companyDescription = validateRegex(textRegex, descriptionInput, "Descrição");
    if (companyName != '' && companyEmail != '' && companyCnpj != '' && companyState != '' && companyCountry != '' && companyCep != '' && companyDescription != '') {
        const company = new Company(companyName, companyEmail, companyCnpj, companyState, companyCountry, companyCep, companyDescription);
        companyList.push(company);
        alert(`Empresa ${company.name} Cadastrada!`);
    }
}
function registerJobVacancy() {
    const jobTitle = document.getElementById("jobTitle").value;
    const jobDescription = document.getElementById('jobDescription').value;
    const skillsSelectJob = document.querySelectorAll('#skillsContainer2 input[name="skills"]:checked');
    const skillsJob = Array.from(skillsSelectJob, option => option.value);
    const companyName = inputCompany.value.toString();
    const companyJob = findCompanyByName(companyName);
    if (companyJob) {
        if (jobTitle != '' && jobDescription != '' && skillsJob.length > 0) {
            companyJob.addVacancy(jobTitle, jobDescription, skillsJob);
            alert(`Vaga cadastrada na empresa ${companyName}`);
        }
    }
    else {
        alert('O nome da empresa deve ser digitado!');
    }
}
function searchCompany() {
    const companyName = inputCompany.value.toString();
    showCompanyDetails(companyName);
}
function deleteCompany() {
    const companyToDelete = inputCompany.value.toString();
    if (showCompany) {
        if (btnDeleteCompany) {
            const indexToDelete = companyList.findIndex(company => company.name === companyToDelete);
            if (indexToDelete !== -1) {
                companyList.splice(indexToDelete, 1);
                alert('Empresa deletada!');
            }
            else {
                alert('Empresa não encontrada!');
            }
        }
    }
}
function showCompanyDetails(name) {
    const company = findCompanyByName(name);
    showCompany.innerHTML = '';
    if (company) {
        const title = document.createElement('h2');
        title.textContent = "Perfil: ";
        showCompany.appendChild(title);
        const dataList = document.createElement('ul');
        const name = document.createElement('li');
        name.textContent = ` Nome: ${company.name}`;
        dataList.appendChild(name);
        const email = document.createElement('li');
        email.textContent = ` Email: ${company.email}`;
        dataList.appendChild(email);
        const cnpj = document.createElement('li');
        cnpj.textContent = ` Idade: ${company.cnpj}`;
        dataList.appendChild(cnpj);
        const state = document.createElement('li');
        state.textContent = ` Estado: ${company.state}`;
        dataList.appendChild(state);
        const country = document.createElement('li');
        country.textContent = ` Estado: ${company.country}`;
        dataList.appendChild(country);
        const cep = document.createElement('li');
        cep.textContent = ` CEP: ${company.cep}`;
        dataList.appendChild(cep);
        const description = document.createElement('li');
        description.textContent = ` Descrição: ${company.description}`;
        dataList.appendChild(description);
        dataList.style.listStyleType = 'none';
        showCompany.appendChild(dataList);
    }
    else {
        alert('Empresa não encontrada');
    }
}
function showApplicantRegistered() {
    const registeredApplicants = document.getElementById('applicantRegistered');
    if (registeredApplicants) {
        registeredApplicants.innerHTML = '';
        applicantList.forEach((applicant, index) => {
            const applicantTitle = document.createElement('h2');
            applicantTitle.textContent = `Candidato: ${index + 1}`;
            registeredApplicants.appendChild(applicantTitle);
            const skillsTitle = document.createElement('h3');
            skillsTitle.textContent = 'Skills: ';
            registeredApplicants.appendChild(skillsTitle);
            const skillList = document.createElement('ul');
            applicant.skills.forEach(skill => {
                const skillItem = document.createElement('li');
                skillItem.textContent = skill;
                skillList.appendChild(skillItem);
            });
            registeredApplicants.appendChild(skillList);
            const education = document.createElement('h3');
            education.textContent = `Education: ${applicant.education}`;
            registeredApplicants.appendChild(education);
        });
    }
}
function findCompanyByName(name) {
    return companyList.find(company => company.name === name);
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
