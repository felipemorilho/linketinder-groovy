function fillSkillsOptions(container: string) {

    const skillsList = document.getElementById(container);

    if (skillsList) {

        skillsList.innerHTML = '';

        const skillValues = Object.values(Skill) as string[];

        for (const skill of skillValues) {

            if (Object.prototype.hasOwnProperty.call(Skill, skill)) {

                    const option = document.createElement('input');
                    option.type = 'checkbox'
                    option.name = 'skills';
                    option.value = skill;

                    const label = document.createElement('label');
                    label.appendChild(option);
                    label.appendChild(document.createTextNode(skill));

                    skillsList.appendChild(label);

            }
        }
    }
}