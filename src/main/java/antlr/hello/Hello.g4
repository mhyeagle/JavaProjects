// Define a grammar called Hello
grammar Hello;

r   : 'hello' ID;
ID  : [a-z]+;
WS  : [ \t\n\r]+ -> skip;
