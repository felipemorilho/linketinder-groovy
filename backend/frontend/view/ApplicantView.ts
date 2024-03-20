document.getElementById('btnShowApplicant')?.addEventListener('click', () => {

    clearHTML(profileApplicant);
    clearHTML(vacancyList);

});

function showApplicantDetails(name: string): void {

    const applicant = findApplicantByName(name);

    profileApplicant.innerHTML = '';

    if (applicant) {

        const title = document.createElement('h2');
        title.textContent = "Perfil: "
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

        
    } else {
        
        alert('Candidato não Existe!')
    }
}

function findApplicantByName(name: string) {

    return applicantList.find(applicant => applicant.name === name);

}

function showVacancies() {

    const showVacancyList = document.getElementById('vacancyList');

    if(showVacancyList){

        const vacancyList = getAllVacancies();

        showVacancyList.innerHTML = '';
        
        const listItem = document.createElement('li');

        if(vacancyList.length != 0) {

            vacancyList.forEach(vacancy => {

                listItem.textContent += `Vaga: ${vacancy.jobTitle} | `;
                listItem.textContent += `Descrição: ${vacancy.jobDescription} | `;
                listItem.textContent += `Skills: ${vacancy.requiredSkills.join(', ')} `;

                showVacancyList.appendChild(listItem);
                
            })

        } else {

            listItem.textContent = "Não há vagas cadastradas!"

            showVacancyList.appendChild(listItem);

        }
    }
}