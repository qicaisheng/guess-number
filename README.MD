## 需求
实现猜数字的游戏。游戏有四个格子，每个格子有一个0到9的数字，任意两个格子的数字都不一样。
你有6次猜测的机会，如果猜对则获胜，否则失败。
每次猜测时需依序输入4个数字，程序会根据猜测的情况给出xAxB的反馈，A前面的数字代表位置和数字都对的个数，B前面的数字代表数字对但是位置不对的个数。

例如：答案是1 2 3 4， 那么对于不同的输入，有如下的输出

Input　　    Output             Instruction

1 5 6 7        1A0B                 1 correct
2 4 7 8        0A2B                 2 and 4 wrong position
0 3 2 4        1A2B                 4 correct，2 and 3 wrong position
5 6 7 8        0A0B                 all wrong
4 3 2 1        0A4B                 4 numbers position wrong
1 2 3 4        4A0B                 win, all correct
1 1 2 3      Wrong Input，Input again
1 2            Wrong Input，Input again
答案在游戏开始时随机生成。输入只有6次机会，在每次猜测时，程序应给出当前猜测的结果，以及之前所有猜测的数字和结果以供玩家参考。


## Tasking
guess number
- given Game with answer 1 2 3 4, when input 1 5 6 7, then output 1A0B
- given Game with answer 1 2 3 4, when input 2 4 7 8, then output 0A2B
- given Game with answer 1 2 3 4, when input 0 3 2 4, then output 1A2B
- given Game with answer 1 2 3 4, when input 1 2 3 4, then output 4A0B

validate input
- given Game with answer 1 2 3 4, when input 1 1 2 3, then output Wrong Input，Input again
- given Game with answer 1 2 3 4, when input 1 2, then output Wrong Input，Input again

end game
- give Game with answer 1 2 3 4, when input 1 2 3 4, then success
- give Game with answer 1 2 3 4 and 6 chances left to guess, when input 1 2 5 8, then user can try again, the chances left will be 5
- give Game with answer 1 2 3 4 and 1 chances left to guess, when input 1 2 5 8, then failed

guess history
- given Game with answer 1 2 3 4 and 1 not succeed guess with input 1 5 6 7, when input 2 4 7 8, then output 0A2B and history 1 5 6 7  1A0B\n

generate answer


## PMD
- Use Gradle
    - run `./gradlew clean pmdMain`
- Use Maven
    - run `./mvnw clean pmd:pmd`