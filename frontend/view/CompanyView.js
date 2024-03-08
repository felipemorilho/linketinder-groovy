"use strict";
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
    if (applicantRegistered) {
        applicantRegistered.innerHTML = '';
        applicantList.forEach((applicant, index) => {
            const applicantTitle = document.createElement('h2');
            applicantTitle.textContent = `Candidato: ${index + 1}`;
            applicantRegistered.appendChild(applicantTitle);
            const skillsTitle = document.createElement('h3');
            skillsTitle.textContent = 'Skills: ';
            applicantRegistered.appendChild(skillsTitle);
            const skillList = document.createElement('ul');
            applicant.skills.forEach(skill => {
                const skillItem = document.createElement('li');
                skillItem.textContent = skill;
                skillList.appendChild(skillItem);
            });
            applicantRegistered.appendChild(skillList);
            const education = document.createElement('h3');
            education.textContent = `Formação: ${applicant.education}`;
            applicantRegistered.appendChild(education);
        });
    }
}
function findCompanyByName(name) {
    return companyList.find(company => company.name === name);
}
