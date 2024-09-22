# Aula03 - Notes

Modo de execução:

        $ javac JGalo.java (Apenas na primeira execução)  
        $ java JGalo (repetida todas as vezes que quiser reiniar o jogo)
    
----------------------------------------

Breve resumo do funcionamento:

    Ficheiros: 
        - No ficheiro JGalo.java é tratada toda o funcionamento utilizador-jogo

        - No ficheiro JGaloInterface.java são declaradas as funções usadas no funcionamento do jogo

        - No ficheiro JGaloEngine.java são reescritas as funções declaradas em JGaloInterface.java
    
    Funções:
        - getActualPlayer() : retorna um char correspondente à representação do player (usando a variavel controlPlayer que a cada execução é mudada)

        - setJogada() : adiciona a jogada ao array bidimensional board

        - isFinished() : tenta todas as possiveis soluções para perceber se o jogo já está acabado
            - em caso do jogo não ter acabado: return false
            - em caso do jogo ter acabado: return true
                - define quem ganhou na variavel 'winner'
                - em caso de empate winner continuara a ser ' '

        - checkResult() : retorna o winner 

