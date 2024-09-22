# Aula01 - Notes

sopa0x.txt -> files de sopa de letras que funcionam 

Ficheiros z_validacao com exemplos de sopa de letras invalidas e que portanto não podem ser resolvidas se as passarmos como argumento no exercício 1 (WSSolver)
PrintOUTs dos resultados destas validações:

belchior@Belchior-Zenbook:/media/belchior/OS/OneDrive - Universidade de Aveiro/ano_2/2_semestre/PDS/practical-g1_04/lab01$ javac WSSolver.java 
belchior@Belchior-Zenbook:/media/belchior/OS/OneDrive - Universidade de Aveiro/ano_2/2_semestre/PDS/practical-g1_04/lab01$ java WSSolver sopa01.txt 
belchior@Belchior-Zenbook:/media/belchior/OS/OneDrive - Universidade de Aveiro/ano_2/2_semestre/PDS/practical-g1_04/lab01$ java WSSolver sopa02.txt 
belchior@Belchior-Zenbook:/media/belchior/OS/OneDrive - Universidade de Aveiro/ano_2/2_semestre/PDS/practical-g1_04/lab01$ java WSSolver sopa03.txt 
belchior@Belchior-Zenbook:/media/belchior/OS/OneDrive - Universidade de Aveiro/ano_2/2_semestre/PDS/practical-g1_04/lab01$ java WSSolver z_validacao_1_max40.txt 
Exception in thread "main" java.lang.IllegalArgumentException: Sopa de letras inválida
	at SoupSolver.soupToData(SoupSolver.java:60)
	at SoupSolver.<init>(SoupSolver.java:28)
	at WSSolver.main(WSSolver.java:13)
belchior@Belchior-Zenbook:/media/belchior/OS/OneDrive - Universidade de Aveiro/ano_2/2_semestre/PDS/practical-g1_04/lab01$ java WSSolver z_validacao_1_min3.txt 
Exception in thread "main" java.lang.IllegalArgumentException: Sopa de letras inválida
	at SoupSolver.soupToData(SoupSolver.java:60)
	at SoupSolver.<init>(SoupSolver.java:28)
	at WSSolver.main(WSSolver.java:13)
belchior@Belchior-Zenbook:/media/belchior/OS/OneDrive - Universidade de Aveiro/ano_2/2_semestre/PDS/practical-g1_04/lab01$ java WSSolver z_validacao_1_quadrado.txt 
Exception in thread "main" java.lang.IllegalArgumentException: Sopa de letras inválida
	at SoupSolver.soupToData(SoupSolver.java:60)
	at SoupSolver.<init>(SoupSolver.java:28)
	at WSSolver.main(WSSolver.java:13)
belchior@Belchior-Zenbook:/media/belchior/OS/OneDrive - Universidade de Aveiro/ano_2/2_semestre/PDS/practical-g1_04/lab01$ java WSSolver z_validacao_2_puzzleMaiuscula.txt 
Exception in thread "main" java.lang.IllegalArgumentException: Sopa de letras inválida
	at SoupSolver.soupToData(SoupSolver.java:60)
	at SoupSolver.<init>(SoupSolver.java:28)
	at WSSolver.main(WSSolver.java:13)
belchior@Belchior-Zenbook:/media/belchior/OS/OneDrive - Universidade de Aveiro/ano_2/2_semestre/PDS/practical-g1_04/lab01$ java WSSolver z_validacao_3_listaEmMinusculaOUMista.txt 
Exception in thread "main" java.lang.IllegalArgumentException: Na lista, as palavras podem ser compostas só por letras minúsculas, ou misturadas (minúsculas e maiúsculas); Palavra Errada: ASD
	at SoupSolver.soupToData(SoupSolver.java:92)
	at SoupSolver.<init>(SoupSolver.java:28)
	at WSSolver.main(WSSolver.java:13)
belchior@Belchior-Zenbook:/media/belchior/OS/OneDrive - Universidade de Aveiro/ano_2/2_semestre/PDS/practical-g1_04/lab01$ java WSSolver z_validacao_4_palavrasCompostasPorAlphaChars.txt 
Exception in thread "main" java.lang.IllegalArgumentException: Sopa de letras inválida
	at SoupSolver.soupToData(SoupSolver.java:60)
	at SoupSolver.<init>(SoupSolver.java:28)
	at WSSolver.main(WSSolver.java:13)
belchior@Belchior-Zenbook:/media/belchior/OS/OneDrive - Universidade de Aveiro/ano_2/2_semestre/PDS/practical-g1_04/lab01$ java WSSolver z_validacao_5_LinhaVaziaLista.txt 
Exception in thread "main" java.lang.IllegalArgumentException: Na lista de palavras o ficheiro não pode conter linhas vazias
	at SoupSolver.soupToData(SoupSolver.java:89)
	at SoupSolver.<init>(SoupSolver.java:28)
	at WSSolver.main(WSSolver.java:13)
belchior@Belchior-Zenbook:/media/belchior/OS/OneDrive - Universidade de Aveiro/ano_2/2_semestre/PDS/practical-g1_04/lab01$ java WSSolver z_validacao_5_LinhaVaziaPuzzle.txt 
Exception in thread "main" java.lang.IllegalArgumentException: Sopa de letras inválida
	at SoupSolver.soupToData(SoupSolver.java:60)
	at SoupSolver.<init>(SoupSolver.java:28)
	at WSSolver.main(WSSolver.java:13)
belchior@Belchior-Zenbook:/media/belchior/OS/OneDrive - Universidade de Aveiro/ano_2/2_semestre/PDS/practical-g1_04/lab01$ java WSSolver z_validacao_7_listaPalavrasCharsOnly.txt 
Exception in thread "main" java.lang.IllegalArgumentException: Na lista, as palavras podem ser compostas só por letras minúsculas, ou misturadas (minúsculas e maiúsculas); Palavra Errada: 2das
	at SoupSolver.soupToData(SoupSolver.java:92)
	at SoupSolver.<init>(SoupSolver.java:28)
	at WSSolver.main(WSSolver.java:13)
belchior@Belchior-Zenbook:/media/belchior/OS/OneDrive - Universidade de Aveiro/ano_2/2_semestre/PDS/practical-g1_04/lab01$ java WSSolver z_validacao_7_listaPalavrasMaxLetters.txt 
Exception in thread "main" java.lang.IllegalArgumentException: As palavras têm de ter no mínimo 3 letras e no máximo 4 (valor máximo calculado de acordo com a sopa de letras atual);Palavra Errada: dasdsa
	at SoupSolver.soupToData(SoupSolver.java:73)
	at SoupSolver.<init>(SoupSolver.java:28)
	at WSSolver.main(WSSolver.java:13)
belchior@Belchior-Zenbook:/media/belchior/OS/OneDrive - Universidade de Aveiro/ano_2/2_semestre/PDS/practical-g1_04/lab01$ java WSSolver z_validacao_7_listaPalavrasMinLetras.txt 
Exception in thread "main" java.lang.IllegalArgumentException: As palavras têm de ter no mínimo 3 letras e no máximo 4 (valor máximo calculado de acordo com a sopa de letras atual);Palavra Errada: hi
	at SoupSolver.soupToData(SoupSolver.java:73)
	at SoupSolver.<init>(SoupSolver.java:28)
	at WSSolver.main(WSSolver.java:13)
belchior@Belchior-Zenbook:/media/belchior/OS/OneDrive - Universidade de Aveiro/ano_2/2_semestre/PDS/practical-g1_04/lab01$ java WSSolver z_validacao_7_listaPalavrasNoCAPSLOCK.txt 
Exception in thread "main" java.lang.IllegalArgumentException: Na lista, as palavras podem ser compostas só por letras minúsculas, ou misturadas (minúsculas e maiúsculas); Palavra Errada: MNOP
	at SoupSolver.soupToData(SoupSolver.java:92)
	at SoupSolver.<init>(SoupSolver.java:28)
	at WSSolver.main(WSSolver.java:13)
belchior@Belchior-Zenbook:/media/belchior/OS/OneDrive - Universidade de Aveiro/ano_2/2_semestre/PDS/practical-g1_04/lab01$ java WSSolver z_validacao_8_PalavraNaoEncontrada.txt 
Exception in thread "main" java.lang.IllegalArgumentException: As palavras têm de ter no mínimo 3 letras e no máximo 4 (valor máximo calculado de acordo com a sopa de letras atual);Palavra Errada: wordNotFound
	at SoupSolver.soupToData(SoupSolver.java:73)
	at SoupSolver.<init>(SoupSolver.java:28)
	at WSSolver.main(WSSolver.java:13)
belchior@Belchior-Zenbook:/media/belchior/OS/OneDrive - Universidade de Aveiro/ano_2/2_semestre/PDS/practical-g1_04/lab01$ java WSSolver z_validacao_8_PalavraRepetente.txt 
Exception in thread "main" java.lang.IllegalArgumentException: Cada palavra só pode estar no puzzle uma vez; Palavra Repetida: bola
	at SoupSolver.solve(SoupSolver.java:259)
	at WSSolver.main(WSSolver.java:14)