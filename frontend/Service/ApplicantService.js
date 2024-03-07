"use strict";
var _a;
const applicantList = [];
fillSkillsOptions('skillsContainer');
// nameApplicant: string = '';
// ageApplicant
// emailApplicant
// cpfApplicant
// stateApplicant
// cepApplicant
// educationApplicant
// descriptionApplicant
const input = document.getElementById('applicantName');
const btnDelete = document.getElementById('btnDelete');
const profileApplicant = document.getElementById('showApplicantProfile');
const vacancyList = document.getElementById('vacancyList');
const skillType = Object.values(Skill);
let skillsChart = null;
const ageRegex = /^[1-9]\d{0,1}$/;
const cpfRegex = /\d{3}\.\d{3}\.\d{3}-\d{2}/;
(_a = document.getElementById('btnShowApplicant')) === null || _a === void 0 ? void 0 : _a.addEventListener('click', () => {
    clearHTML(profileApplicant);
    clearHTML(vacancyList);
});
function registerApplicant() {
    const nameApplicantInput = document.getElementById("name").value;
    const emailApplicantInput = document.getElementById("email").value;
    const stateApplicantInput = document.getElementById("state").value;
    const cepApplicantInput = document.getElementById("cep").value;
    const educationApplicantInput = document.getElementById("education").value;
    const descriptionApplicantInput = document.getElementById("description").value;
    const ageApplicantInput = document.getElementById("age").value;
    const cpfApplicantInput = document.getElementById("cpf").value;
    const skillsSelect = document.querySelectorAll('#skillsContainer input[name="skills"]:checked');
    const skills = Array.from(skillsSelect, option => option.value);
    const nameApplicant = validateRegex(textRegex, nameApplicantInput, "Nome");
    const emailApplicant = validateRegex(emailRegex, emailApplicantInput, "Email");
    const stateApplicant = validateRegex(textRegex, stateApplicantInput, "Estado");
    const cepApplicant = validateRegex(cepRegex, cepApplicantInput, "CEP");
    const educationApplicant = validateRegex(textRegex, educationApplicantInput, "Formação");
    const descriptionApplicant = validateRegex(textRegex, descriptionApplicantInput, "Descrição");
    const ageApplicant = parseInt(validateRegex(ageRegex, ageApplicantInput, "Idade"));
    const cpfApplicant = validateRegex(cpfRegex, cpfApplicantInput, "CPF");
    if (skills.length == 0) {
        alert("Preencha pelo menos uma skill.");
    }
    if (nameApplicant != '' && ageApplicant > 0 && emailApplicant != '' && cpfApplicant != '' && stateApplicant != '' && cepApplicant != '' && educationApplicant != '' && descriptionApplicant != '' && skills.length > 0) {
        const applicant = new Applicant(nameApplicant, ageApplicant, emailApplicant, cpfApplicant, stateApplicant, cepApplicant, educationApplicant, descriptionApplicant, skills);
        applicantList.push(applicant);
        alert(`Candidato Cadastrado!`);
    }
}
function searchApplicant() {
    const applicantName = input.value.toString();
    showApplicantDetails(applicantName);
}
function deleteApplicant() {
    const applicantToDelete = input.value.toString();
    if (profileApplicant) {
        if (btnDelete) {
            const indexToDelete = applicantList.findIndex(applicant => applicant.name === applicantToDelete);
            if (indexToDelete !== -1) {
                applicantList.splice(indexToDelete, 1);
                alert('Candidato deletado!');
            }
            else {
                alert('Candidato não encontrado!');
            }
        }
    }
}
function showApplicantDetails(name) {
    const applicant = findApplicantByName(name);
    profileApplicant.innerHTML = '';
    if (applicant) {
        const title = document.createElement('h2');
        title.textContent = "Perfil: ";
        profileApplicant.appendChild(title);
        const dataList = document.createElement('ul');
        const name = document.createElement('li');
        name.textContent = ` Nome: ${applicant.name}`;
        dataList.appendChild(name);
        const age = document.createElement('li');
        age.textContent = ` Idade: ${applicant.age}`;
        dataList.appendChild(age);
        const email = document.createElement('li');
        email.textContent = ` Email: ${applicant.email}`;
        dataList.appendChild(email);
        const cpf = document.createElement('li');
        email.textContent = ` CPF: ${applicant.cpf}`;
        dataList.appendChild(cpf);
        const state = document.createElement('li');
        state.textContent = ` Estado: ${applicant.state}`;
        dataList.appendChild(state);
        const cep = document.createElement('li');
        cep.textContent = ` CEP: ${applicant.cep}`;
        dataList.appendChild(cep);
        const education = document.createElement('li');
        education.textContent = ` Formação: ${applicant.education}`;
        dataList.appendChild(education);
        const description = document.createElement('li');
        description.textContent = ` Descrição: ${applicant.description}`;
        dataList.appendChild(description);
        const skills = document.createElement('li');
        skills.textContent = ` Skills: ${applicant.skills.join(', ')}`;
        dataList.appendChild(skills);
        dataList.style.listStyleType = 'none';
        profileApplicant.appendChild(dataList);
    }
    else {
        alert('Candidato não Existe!');
    }
}
function findApplicantByName(name) {
    return applicantList.find(applicant => applicant.name === name);
}
function getAllVacancies() {
    const allVacancies = [];
    for (const company of companyList) {
        allVacancies.push(...company.vacancies);
    }
    return allVacancies;
}
function showVacancies() {
    const showVacancyList = document.getElementById('vacancyList');
    if (showVacancyList) {
        const vacancyList = getAllVacancies();
        showVacancyList.innerHTML = '';
        vacancyList.forEach(vacancy => {
            const listItem = document.createElement('li');
            listItem.textContent += `Vaga: ${vacancy.jobTitle} | `;
            listItem.textContent += `Descrição: ${vacancy.jobDescription} | `;
            listItem.textContent += `Skills: ${vacancy.requiredSkills.join(', ')} `;
            showVacancyList.appendChild(listItem);
        });
    }
}
