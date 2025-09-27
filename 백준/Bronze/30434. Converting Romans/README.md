# [Bronze I] Converting Romans - 30434 

[문제 링크](https://www.acmicpc.net/problem/30434) 

### 성능 요약

메모리: 35248 KB, 시간: 104 ms

### 분류

구현, 문자열

### 제출 일자

2025년 9월 27일 19:24:47

### 문제 설명

<p>The Roman numerals are a numeral system that originated in ancient Rome and was widely used throughout Europe well into the Late Middle Ages. It differs from the Arabic system that we mostly use today in that numbers are written with combinations of letters from the Latin alphabet, where each letter is assigned a fixed integer value.  Over the years many different letters were used, which was a cause of frequent confusion.  But "modern" style uses only these seven:</p>

<table class="table table-bordered table-center-50 td-center th-center">
	<tbody>
		<tr>
			<th>I</th>
			<th>V</th>
			<th>X</th>
			<th>L</th>
			<th>C</th>
			<th>D</th>
			<th>M</th>
		</tr>
		<tr>
			<td>1</td>
			<td>5</td>
			<td>10</td>
			<td>50</td>
			<td>100</td>
			<td>500</td>
			<td>1000</td>
		</tr>
	</tbody>
</table>

<p>A very common misunderstanding of the Roman numerals is that they use a universal subtractive syntax. In a subtractive syntax, a lower digit written before a larger digit will be subtracted from the larger digit. 4 can be written as IIII and IV <mjx-container class="MathJax" jax="CHTML" style="font-size: 111.4%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mn class="mjx-n"><mjx-c class="mjx-c35"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2212"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mo stretchy="false">(</mo><mn>5</mn><mo>−</mo><mn>1</mn><mo stretchy="false">)</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$(5-1)$</span></mjx-container>. Romans themselves only really used the subtractive syntax for smaller numbers. For larger numbers, it was largely avoided, to give more clarity. For example, <mjx-container class="MathJax" jax="CHTML" style="font-size: 111.4%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c34"></mjx-c><mjx-c class="mjx-c39"></mjx-c><mjx-c class="mjx-c39"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>499</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$499$</span></mjx-container> can be written LDVLIV, XDIX, VDIV or ID, while older sources most likely would use CDXCIX. Ain't Roman numbers fun?</p>

<p>You are given <mjx-container class="MathJax" jax="CHTML" style="font-size: 111.4%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45B TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>n</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$n$</span></mjx-container> numbers written in the Roman numeral system, and your task is to convert them to the regular Arabic number system.</p>

<p>For the purposes of this problem we will subtract any digit written to the left of a larger digit, even if they are not directly adjacent.</p>

### 입력 

 <p>The inputs starts with an integer <mjx-container class="MathJax" jax="CHTML" style="font-size: 111.4%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c3C"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4"><mjx-c class="mjx-c1D45B TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-msup space="4"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn><mjx-script style="vertical-align: 0.393em;"><mjx-mn class="mjx-n" size="s"><mjx-c class="mjx-c33"></mjx-c></mjx-mn></mjx-script></mjx-msup></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>0</mn><mo><</mo><mi>n</mi><mo>≤</mo><msup><mn>10</mn><mn>3</mn></msup></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$0 < n \leq 10^3$</span></mjx-container>. Then follow <mjx-container class="MathJax" jax="CHTML" style="font-size: 111.4%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45B TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>n</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$n$</span></mjx-container> lines, each containing up to <mjx-container class="MathJax" jax="CHTML" style="font-size: 111.4%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c33"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c22C5"></mjx-c></mjx-mo><mjx-msup space="3"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn><mjx-script style="vertical-align: 0.393em;"><mjx-mn class="mjx-n" size="s"><mjx-c class="mjx-c35"></mjx-c></mjx-mn></mjx-script></mjx-msup></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>3</mn><mo>⋅</mo><msup><mn>10</mn><mn>5</mn></msup></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$3 \cdot 10^5$</span></mjx-container> Roman digits. The total number of Roman digits in the input is at most <mjx-container class="MathJax" jax="CHTML" style="font-size: 111.4%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c33"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c22C5"></mjx-c></mjx-mo><mjx-msup space="3"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn><mjx-script style="vertical-align: 0.393em;"><mjx-mn class="mjx-n" size="s"><mjx-c class="mjx-c35"></mjx-c></mjx-mn></mjx-script></mjx-msup></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>3</mn><mo>⋅</mo><msup><mn>10</mn><mn>5</mn></msup></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$3 \cdot 10^5$</span></mjx-container>.</p>

### 출력 

 <p>Output the corresponding Arabic numbers, one number per line.</p>

