grammar PCF;

// règles syntaxiques

program : term EOF ;
term : VARIABLE                              # Var
     | term term                             # App
     | LIT                                   # Lit
     | '(' term ')'                          # Par
     | term OP2 term                         # BinOp
     | term OP term                          # BinOp
//     | 'var' VARIABLE '=' term               # Var
     | 'let' VARIABLE '=' term 'in' term     # Let
     | 'ifz' term 'then' term 'else' term    # Cond
     | 'fun' VARIABLE '->' term              # Fun
     ;

// règles lexicales
OP  : '+' | '-' ;
OP2 : '*' | '/' ;
LIT : '0' | [1-9][0-9]* ;
VARIABLE : [a-zA-Z_]+ ;
LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN) ;
WS : [ \t\n\r]+ -> channel(HIDDEN) ;
