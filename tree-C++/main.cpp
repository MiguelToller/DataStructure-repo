#include <iostream>
#include <cstdlib>

using namespace std;

#include "arvore.h"

int main() {

    Arvore *arvore = NULL;
    arvore = inserir(50, arvore);
    arvore = inserir(35, arvore);
    arvore = inserir(40, arvore);
    arvore = inserir(60, arvore);

    cout << "\nElementos: " << endl;
    exibirOrdenado(arvore);

    cout << "\nTotal de elementos: " << contar(arvore) << endl;
    cout << "Numeros Pares: " << contarPares(arvore) << endl;
    cout << "Numeros Folhas: " << contarFolhas(arvore) << endl;

    cout << "\nFolhas: " << endl;
    exibirFolhas(arvore);

    int valor = 32;
    cout << "\nValor " << valor << (localizar(valor, arvore) ? " encontrado." : " nao encontrado.") << endl;

    return 1;
}