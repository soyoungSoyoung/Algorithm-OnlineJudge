# [level 2] 조건에 맞는 사원 정보 조회하기 - 284527 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/284527) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2024년 09월 19일 09:20:56

### 문제 설명

<p style="user-select: auto !important;"><code style="user-select: auto !important;">HR_DEPARTMENT</code> 테이블은 회사의 부서 정보를 담은 테이블입니다. <code style="user-select: auto !important;">HR_DEPARTMENT</code> 테이블의 구조는 다음과 같으며 <code style="user-select: auto !important;">DEPT_ID</code>, <code style="user-select: auto !important;">DEPT_NAME_KR</code>, <code style="user-select: auto !important;">DEPT_NAME_EN</code>, <code style="user-select: auto !important;">LOCATION</code>은 각각 부서 ID, 국문 부서명, 영문 부서명, 부서 위치를 의미합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">Column name</th>
<th style="user-select: auto !important;">Type</th>
<th style="user-select: auto !important;">Nullable</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">DEPT_ID</td>
<td style="user-select: auto !important;">VARCHAR</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">DEPT_NAME_KR</td>
<td style="user-select: auto !important;">VARCHAR</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">DEPT_NAME_EN</td>
<td style="user-select: auto !important;">VARCHAR</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">LOCATION</td>
<td style="user-select: auto !important;">VARCHAR</td>
<td style="user-select: auto !important;">FLASE</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">HR_EMPLOYEES</code> 테이블은 회사의 사원 정보를 담은 테이블입니다. <code style="user-select: auto !important;">HR_EMPLOYEES</code> 테이블의 구조는 다음과 같으며 <code style="user-select: auto !important;">EMP_NO</code>, <code style="user-select: auto !important;">EMP_NAME</code>, <code style="user-select: auto !important;">DEPT_ID</code>, <code style="user-select: auto !important;">POSITION</code>, <code style="user-select: auto !important;">EMAIL</code>, <code style="user-select: auto !important;">COMP_TEL</code>, <code style="user-select: auto !important;">HIRE_DATE</code>, <code style="user-select: auto !important;">SAL</code>은 각각 사번, 성명, 부서 ID, 직책, 이메일, 전화번호, 입사일, 연봉을 의미합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">Column name</th>
<th style="user-select: auto !important;">Type</th>
<th style="user-select: auto !important;">Nullable</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">EMP_NO</td>
<td style="user-select: auto !important;">VARCHAR</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">EMP_NAME</td>
<td style="user-select: auto !important;">VARCHAR</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">DEPT_ID</td>
<td style="user-select: auto !important;">VARCHAR</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">POSITION</td>
<td style="user-select: auto !important;">VARCHAR</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">EMAIL</td>
<td style="user-select: auto !important;">VARCHAR</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">COMP_TEL</td>
<td style="user-select: auto !important;">VARCHAR</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">HIRE_DATE</td>
<td style="user-select: auto !important;">DATE</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">SAL</td>
<td style="user-select: auto !important;">NUMBER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">HR_GRADE</code> 테이블은 2022년 사원의 평가 정보를 담은 테이블입니다. <code style="user-select: auto !important;">HR_GRADE</code>의 구조는 다음과 같으며 <code style="user-select: auto !important;">EMP_NO</code>, <code style="user-select: auto !important;">YEAR</code>, <code style="user-select: auto !important;">HALF_YEAR</code>, <code style="user-select: auto !important;">SCORE</code>는 각각 사번, 연도, 반기, 평가 점수를 의미합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">Column name</th>
<th style="user-select: auto !important;">Type</th>
<th style="user-select: auto !important;">Nullable</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">EMP_NO</td>
<td style="user-select: auto !important;">VARCHAR</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">YEAR</td>
<td style="user-select: auto !important;">NUMBER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">HALF_YEAR</td>
<td style="user-select: auto !important;">NUMBER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">SCORE</td>
<td style="user-select: auto !important;">NUMBER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">문제</h5>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">HR_DEPARTMENT</code>, <code style="user-select: auto !important;">HR_EMPLOYEES</code>, <code style="user-select: auto !important;">HR_GRADE</code> 테이블에서 2022년도 한해 평가 점수가 가장 높은 사원 정보를 조회하려 합니다. 2022년도 평가 점수가 가장 높은 사원들의 점수, 사번, 성명, 직책, 이메일을 조회하는 SQL문을 작성해주세요.</p>

<p style="user-select: auto !important;">2022년도의 평가 점수는 상,하반기 점수의 합을 의미하고, 평가 점수를 나타내는 컬럼의 이름은 <code style="user-select: auto !important;">SCORE</code>로 해주세요.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">예시</h5>

<p style="user-select: auto !important;">예를 들어 <code style="user-select: auto !important;">HR_DEPARTMENT</code> 테이블이 다음과 같고</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">DEPT_ID</th>
<th style="user-select: auto !important;">DEPT_NAME_KR</th>
<th style="user-select: auto !important;">DEPT_NAME_EN</th>
<th style="user-select: auto !important;">LOCATION</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">D0001</td>
<td style="user-select: auto !important;">법무팀</td>
<td style="user-select: auto !important;">Law Dep</td>
<td style="user-select: auto !important;">그렙타워 4층</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">D0002</td>
<td style="user-select: auto !important;">인사팀</td>
<td style="user-select: auto !important;">Human resources</td>
<td style="user-select: auto !important;">그렙타워 4층</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">D0003</td>
<td style="user-select: auto !important;">총무팀</td>
<td style="user-select: auto !important;">General Affairs</td>
<td style="user-select: auto !important;">그렙타워 4층</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">HR_EMPLOYEES</code> 테이블이 다음과 같고</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">EMP_NO</th>
<th style="user-select: auto !important;">EMP_NAME</th>
<th style="user-select: auto !important;">DEPT_ID</th>
<th style="user-select: auto !important;">POSITION</th>
<th style="user-select: auto !important;">EMAIL</th>
<th style="user-select: auto !important;">COMP_TEL</th>
<th style="user-select: auto !important;">HIRE_DATE</th>
<th style="user-select: auto !important;">SAL</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2017002</td>
<td style="user-select: auto !important;">정호식</td>
<td style="user-select: auto !important;">D0001</td>
<td style="user-select: auto !important;">팀장</td>
<td style="user-select: auto !important;"><a href="mailto:hosick_jung@grepp.com" target="_blank" rel="noopener" style="user-select: auto !important;">hosick_jung@grepp.com</a></td>
<td style="user-select: auto !important;">031-8000-1101</td>
<td style="user-select: auto !important;">2017-03-01</td>
<td style="user-select: auto !important;">65000000</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2018001</td>
<td style="user-select: auto !important;">김민석</td>
<td style="user-select: auto !important;">D0001</td>
<td style="user-select: auto !important;">팀원</td>
<td style="user-select: auto !important;"><a href="mailto:minseock_kim@grepp.com" target="_blank" rel="noopener" style="user-select: auto !important;">minseock_kim@grepp.com</a></td>
<td style="user-select: auto !important;">031-8000-1102</td>
<td style="user-select: auto !important;">2018-03-01</td>
<td style="user-select: auto !important;">60000000</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2019001</td>
<td style="user-select: auto !important;">김솜이</td>
<td style="user-select: auto !important;">D0002</td>
<td style="user-select: auto !important;">팀장</td>
<td style="user-select: auto !important;"><a href="mailto:somi_kim@grepp.com" target="_blank" rel="noopener" style="user-select: auto !important;">somi_kim@grepp.com</a></td>
<td style="user-select: auto !important;">031-8000-1106</td>
<td style="user-select: auto !important;">2019-03-01</td>
<td style="user-select: auto !important;">60000000</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2020002</td>
<td style="user-select: auto !important;">김연주</td>
<td style="user-select: auto !important;">D0002</td>
<td style="user-select: auto !important;">팀원</td>
<td style="user-select: auto !important;"><a href="mailto:yeonjoo_kim@grepp.com" target="_blank" rel="noopener" style="user-select: auto !important;">yeonjoo_kim@grepp.com</a></td>
<td style="user-select: auto !important;">031-8000-1107</td>
<td style="user-select: auto !important;">2020-03-01</td>
<td style="user-select: auto !important;">53000000</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2020005</td>
<td style="user-select: auto !important;">양성태</td>
<td style="user-select: auto !important;">D0003</td>
<td style="user-select: auto !important;">팀원</td>
<td style="user-select: auto !important;"><a href="mailto:sungtae_yang@grepp.com" target="_blank" rel="noopener" style="user-select: auto !important;">sungtae_yang@grepp.com</a></td>
<td style="user-select: auto !important;">031-8000-1112</td>
<td style="user-select: auto !important;">2020-03-01</td>
<td style="user-select: auto !important;">53000000</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">HR_GRADE</code> 테이블이 다음과 같을 때</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">EMP_NO</th>
<th style="user-select: auto !important;">YEAR</th>
<th style="user-select: auto !important;">HALF_YEAR</th>
<th style="user-select: auto !important;">SCORE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2017002</td>
<td style="user-select: auto !important;">2022</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">92</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2018001</td>
<td style="user-select: auto !important;">2022</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">89</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2019001</td>
<td style="user-select: auto !important;">2022</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">94</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2020002</td>
<td style="user-select: auto !important;">2022</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">90</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2020005</td>
<td style="user-select: auto !important;">2022</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">92</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2017002</td>
<td style="user-select: auto !important;">2022</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">84</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2018001</td>
<td style="user-select: auto !important;">2022</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">89</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2019001</td>
<td style="user-select: auto !important;">2022</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">81</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2020002</td>
<td style="user-select: auto !important;">2022</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">91</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2020005</td>
<td style="user-select: auto !important;">2022</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">81</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">다음과 같이 평가 점수가 가장 높은 사원 정보를 출력해야 합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">SCORE</th>
<th style="user-select: auto !important;">EMP_NO</th>
<th style="user-select: auto !important;">EMP_NAME</th>
<th style="user-select: auto !important;">POSITION</th>
<th style="user-select: auto !important;">EMAIL</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">181</td>
<td style="user-select: auto !important;">202002</td>
<td style="user-select: auto !important;">김연주</td>
<td style="user-select: auto !important;">팀원</td>
<td style="user-select: auto !important;"><a href="mailto:yeonjoo_kim@grepp.com" target="_blank" rel="noopener" style="user-select: auto !important;">yeonjoo_kim@grepp.com</a></td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges