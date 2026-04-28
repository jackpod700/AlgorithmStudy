# [Gold V] Fraction - 30855 

[문제 링크](https://www.acmicpc.net/problem/30855) 

### 성능 요약

메모리: 2020 KB, 시간: 0 ms

### 분류

수학, 자료 구조, 문자열, 파싱, 스택

### 제출 일자

2026년 04월 28일 11:30:22

### 문제 설명

<p>A basic fraction can be represented by three integers $(a\, b\, c)$ which denotes $a + \frac{b}{c}$ where $1 ≤ a, b, c ≤ 9$. An extended fraction has the form of $(a'\, b'\, c')$ where $a'$, $b'$ and $c'$ may be integers between one and nine or other extended fractions. Note that a basic fraction is also an extended fraction, and the length of the fraction is finite.</p>

<p>Given an extended fraction, we want to express its value as irreducible fraction. For example, the irreducible fraction of $\left((1\, 2\, 4)(5\, 2\, 3)\left(4\, 3 (2\, 7\, 3) \right)\right)$ is as follows.</p>

<p>$$\left(1 + \frac{2}{4}\right) + \displaystyle\frac{5 + \displaystyle\frac{2}{3}}{4 + \displaystyle\frac{3}{2 + \displaystyle\frac{7}{3}}} = \displaystyle\frac{991}{366}$$</p>

<p>Given a string form of an extended fraction, write a program that converts the extended fraction into the irreducible fraction.</p>

### 입력 

 <p>Your program is to read from standard input. The input starts with a line containing one integer $n$ ($2 ≤ n ≤ 100$), where $n$ is the number of symbols which are parentheses and digits between $1$ and $9$. The second line contains symbols, separated by a space, which represent an extended fraction.</p>

### 출력 

 <p>Your program is to write to standard output. Print exactly one line. If the answer is $x$/$y$, the line should contain two integers $x$ and $y$, which are relatively prime to each other. Otherwise, (for example, when the input is not valid) print <code>-1</code>. You will need 64-bit integers to get the correct answer.</p>

