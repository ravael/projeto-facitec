package br.facitec.bibliotech.situacao;

public enum SituacaoLivro {

	DISPONIVEL(1), 
	INDISPONIVEL(2);
    
	private final int codigo;

    SituacaoLivro(int codigo) { 
    	this.codigo = codigo; 
    }

    int codigo() { 
    	return codigo; 
    }

    public static SituacaoLivro situacaoPorCodigo(int codigo) {
        for (SituacaoLivro situacao: SituacaoLivro.values()) {
            if (codigo == situacao.codigo()) 
            	return situacao;
        }
        throw new IllegalArgumentException("codigo invalido");
    }
}
