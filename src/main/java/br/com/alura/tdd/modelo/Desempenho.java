package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
    A_DESEJAR {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.03");
        }
    },
    BOM {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.15");
        }
    },
    OTIMO {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.2");
        }
    },
    ESPETACULAR {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.4");
        }
    },
    NAO_ALCANCADO {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal(0.00);
        }
    };

    public abstract BigDecimal percentualReajuste();
}
