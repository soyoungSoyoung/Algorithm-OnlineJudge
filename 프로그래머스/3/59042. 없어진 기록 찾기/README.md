# [level 3] 없어진 기록 찾기 - 59042 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/59042) 

### 성능 요약

메모리: 0.0 MB, 시간: 0.00 ms

### 구분

코딩테스트 연습 > JOIN

### 채점결과

Empty

### 제출 일자

2024년 09월 26일 06:23:06

### 문제 설명

<p style="user-select: auto !important;"><code style="user-select: auto !important;">ANIMAL_INS</code> 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. <code style="user-select: auto !important;">ANIMAL_INS</code> 테이블 구조는 다음과 같으며, <code style="user-select: auto !important;">ANIMAL_ID</code>, <code style="user-select: auto !important;">ANIMAL_TYPE</code>, <code style="user-select: auto !important;">DATETIME</code>, <code style="user-select: auto !important;">INTAKE_CONDITION</code>, <code style="user-select: auto !important;">NAME</code>, <code style="user-select: auto !important;">SEX_UPON_INTAKE</code>는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">NAME</th>
<th style="user-select: auto !important;">TYPE</th>
<th style="user-select: auto !important;">NULLABLE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">ANIMAL_ID</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">ANIMAL_TYPE</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">DATETIME</td>
<td style="user-select: auto !important;">DATETIME</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">INTAKE_CONDITION</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">NAME</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">SEX_UPON_INTAKE</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">ANIMAL_OUTS</code> 테이블은 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블입니다. <code style="user-select: auto !important;">ANIMAL_OUTS</code> 테이블 구조는 다음과 같으며, <code style="user-select: auto !important;">ANIMAL_ID</code>, <code style="user-select: auto !important;">ANIMAL_TYPE</code>, <code style="user-select: auto !important;">DATETIME</code>, <code style="user-select: auto !important;">NAME</code>, <code style="user-select: auto !important;">SEX_UPON_OUTCOME</code>는 각각 동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부를 나타냅니다. <code style="user-select: auto !important;">ANIMAL_OUTS</code> 테이블의 <code style="user-select: auto !important;">ANIMAL_ID</code>는 <code style="user-select: auto !important;">ANIMAL_INS</code>의 <code style="user-select: auto !important;">ANIMAL_ID</code>의 외래 키입니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">NAME</th>
<th style="user-select: auto !important;">TYPE</th>
<th style="user-select: auto !important;">NULLABLE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">ANIMAL_ID</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">ANIMAL_TYPE</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">DATETIME</td>
<td style="user-select: auto !important;">DATETIME</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">NAME</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">SEX_UPON_OUTCOME</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">천재지변으로 인해 일부 데이터가 유실되었습니다. 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회하는 SQL문을 작성해주세요. </p>

<h5 style="user-select: auto !important;">예시</h5>

<p style="user-select: auto !important;">예를 들어, <code style="user-select: auto !important;">ANIMAL_INS</code> 테이블과 <code style="user-select: auto !important;">ANIMAL_OUTS</code> 테이블이 다음과 같다면</p>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">ANIMAL_INS</code></p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">ANIMAL_ID</th>
<th style="user-select: auto !important;">ANIMAL_TYPE</th>
<th style="user-select: auto !important;">DATETIME</th>
<th style="user-select: auto !important;">INTAKE_CONDITION</th>
<th style="user-select: auto !important;">NAME</th>
<th style="user-select: auto !important;">SEX_UPON_INTAKE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">A352713</td>
<td style="user-select: auto !important;">Cat</td>
<td style="user-select: auto !important;">2017-04-13 16:29:00</td>
<td style="user-select: auto !important;">Normal</td>
<td style="user-select: auto !important;">Gia</td>
<td style="user-select: auto !important;">Spayed Female</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">A350375</td>
<td style="user-select: auto !important;">Cat</td>
<td style="user-select: auto !important;">2017-03-06 15:01:00</td>
<td style="user-select: auto !important;">Normal</td>
<td style="user-select: auto !important;">Meo</td>
<td style="user-select: auto !important;">Neutered Male</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">ANIMAL_OUTS</code></p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">ANIMAL_ID</th>
<th style="user-select: auto !important;">ANIMAL_TYPE</th>
<th style="user-select: auto !important;">DATETIME</th>
<th style="user-select: auto !important;">NAME</th>
<th style="user-select: auto !important;">SEX_UPON_OUTCOME</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">A349733</td>
<td style="user-select: auto !important;">Dog</td>
<td style="user-select: auto !important;">2017-09-27 19:09:00</td>
<td style="user-select: auto !important;">Allie</td>
<td style="user-select: auto !important;">Spayed Female</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">A352713</td>
<td style="user-select: auto !important;">Cat</td>
<td style="user-select: auto !important;">2017-04-25 12:25:00</td>
<td style="user-select: auto !important;">Gia</td>
<td style="user-select: auto !important;">Spayed Female</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">A349990</td>
<td style="user-select: auto !important;">Cat</td>
<td style="user-select: auto !important;">2018-02-02 14:18:00</td>
<td style="user-select: auto !important;">Spice</td>
<td style="user-select: auto !important;">Spayed Female</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">ANIMAL_OUTS</code> 테이블에서</p>

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">Allie의 ID는 <code style="user-select: auto !important;">ANIMAL_INS</code>에 없으므로, Allie의 데이터는 유실되었습니다.</li>
<li style="user-select: auto !important;">Gia의 ID는 <code style="user-select: auto !important;">ANIMAL_INS</code>에 있으므로, Gia의 데이터는 유실되지 않았습니다.</li>
<li style="user-select: auto !important;">Spice의 ID는 <code style="user-select: auto !important;">ANIMAL_INS</code>에 없으므로, Spice의 데이터는 유실되었습니다.</li>
</ul>

<p style="user-select: auto !important;">따라서 SQL문을 실행하면 다음과 같이 나와야 합니다. </p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">ANIMAL_ID</th>
<th style="user-select: auto !important;">NAME</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">A349733</td>
<td style="user-select: auto !important;">Allie</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">A349990</td>
<td style="user-select: auto !important;">Spice</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto !important;">

<p style="user-select: auto !important;">본 문제는 <a href="https://www.kaggle.com/aaronschlegel/austin-animal-center-shelter-intakes-and-outcomes" target="_blank" rel="noopener" style="user-select: auto !important;">Kaggle의 "Austin Animal Center Shelter Intakes and Outcomes"</a>에서 제공하는 데이터를 사용하였으며 <a href="https://opendatacommons.org/licenses/odbl/1.0/" target="_blank" rel="noopener" style="user-select: auto !important;">ODbL</a>의 적용을 받습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges