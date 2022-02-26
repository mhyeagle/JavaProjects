// Define a grammar called Hello
grammar Hello;

r   : 'hello' ID    #HelloRuleX
    | 'ant' ID      #ANTRuleX
    ;
ID  : [a-z]+;
WS  : [ \t\n\r]+ -> skip;
