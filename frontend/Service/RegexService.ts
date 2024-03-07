function validateRegex(regexValidation: RegExp, fieldToValidate: string, showFieldName: string): string {

    if(regexValidation.test(fieldToValidate)) {

        return fieldToValidate;

    } else {

        alert(`O campo ${showFieldName} é inválido!`)

        return '';

    }
}