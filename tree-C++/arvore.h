typedef struct no {
    int dado;
    struct no *esq;
    struct no *dir;
} Arvore;

Arvore *inserir(int valor, Arvore *raiz) {
    if (raiz) { // Percurso pré-fixado
        // Percorrer para esquerda ou direita
        if (valor < raiz->dado) {
            // Ir para esquerda
            raiz->esq = inserir(valor, raiz->esq);
        } else {
            // Ir para direita
            raiz->dir = inserir(valor, raiz->dir);
        }
        return raiz;
    }
    Arvore *novo = (Arvore*)malloc(sizeof(Arvore));
    novo->dado = valor;
    novo->esq = NULL;
    novo->dir = NULL;
    return novo;
}

void exibirOrdenado(Arvore *raiz) {
    if (raiz) { // Percurso in-fixado
        exibirOrdenado(raiz->esq);
        cout << raiz->dado << "\t";
        exibirOrdenado(raiz->dir);
    }
}

int contar(Arvore *raiz) {
    if (raiz) { // Percurso pré-fixado
        return 1 + contar(raiz->esq) + contar(raiz->dir);
    }
    return 0;
}

int somar(Arvore *raiz) {
    if (raiz) { // Percurso pré-fixado
        return raiz->dado + somar(raiz->esq) + somar(raiz->dir);
    }
    return 0;
}

int contarPares(Arvore *raiz) {
    if (raiz) { // Percurso pré-fixado
        if (raiz->dado % 2 == 0) {
            return 1 + contarPares(raiz->esq) + contarPares(raiz->dir);
        }
        return contarPares(raiz->esq) + contarPares(raiz->dir);
    }
    return 0;
}

int contarFolhas(Arvore *raiz) {
    if (raiz) { // Percurso pré-fixado
        if (!raiz->esq && !raiz->dir) {
            return 1;
        }
        return contarFolhas(raiz->esq) + contarFolhas(raiz->dir);
    }
    return 0;
}

void exibirFolhas(Arvore *raiz) {
    if (raiz) { // Percurso in-fixado
        if (!raiz->esq && !raiz->dir) {
            cout << raiz->dado << "\t";
        } else {
            exibirFolhas(raiz->esq);
            exibirFolhas(raiz->dir);
        }
    }
}

