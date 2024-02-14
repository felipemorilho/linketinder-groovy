package com.acelerazg.view

class SystemView {

    static String showMenu() {

    Scanner scan = new Scanner (System.in)

    print('''\u001B[32m\nSeja bem-vindo ao LinkeTinder!!! \u001B[0m

Escolha a opção desejada:

1 - Cadastro Candidato
2 - Cadastro Empresa
3 - Listar Candidatos
4 - Listar Empresas
5 - Verificar se há match entre candidato/empresa
0 - Sair

\u001B[33mDigite a opção desejada: \u001B[0m''')

        String option = scan.nextLine()

        return option

    }
}
