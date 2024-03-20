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
        showAlert(`Empresa ${company.name} Cadastrada!`);
    }
}
function registerJobVacancy() {
    const jobTitleInput = document.getElementById("jobTitle").value;
    const jobDescriptionInput = document.getElementById("jobDescription").value;
    const skillsSelectJob = document.querySelectorAll('#skillsContainer2 input[name="skills"]:checked');
    const skillsJob = Array.from(skillsSelectJob, option => option.value);
    const companyNameField = inputCompany.value.toString();
    const jobTitle = validateRegex(textRegex, jobTitleInput, "Título da vaga");
    const jobDescription = validateRegex(textRegex, jobDescriptionInput, "Descrição da vaga");
    if (skillsJob.length == 0) {
        showAlert("Preencha pelo menos uma skill.");
    }
    const companyJob = findCompanyByName(companyNameField);
    if (companyJob) {
        if (jobTitle != '' && jobDescription != '' && skillsJob.length > 0) {
            companyJob.addVacancy(jobTitle, jobDescription, skillsJob);
            showAlert(`Vaga cadastrada na empresa ${companyNameField}`);
        }
    }
    else {
        showAlert('O nome da empresa deve ser digitado!');
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
                showAlert('Empresa deletada!');
            }
            else {
                showAlert('Empresa não encontrada!');
            }
        }
    }
}
