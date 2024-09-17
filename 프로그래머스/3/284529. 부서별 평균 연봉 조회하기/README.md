# [level 3] 부서별 평균 연봉 조회하기 - 284529 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/284529) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2024년 09월 18일 04:27:10

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
<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">문제</h5>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">HR_DEPARTMENT</code>와 <code style="user-select: auto !important;">HR_EMPLOYEES</code> 테이블을 이용해 부서별 평균 연봉을 조회하려 합니다. 부서별로 부서 ID, 영문 부서명, 평균 연봉을 조회하는 SQL문을 작성해주세요.</p>

<p style="user-select: auto !important;">평균연봉은 소수점 첫째 자리에서 반올림하고 컬럼명은 <code style="user-select: auto !important;">AVG_SAL</code>로 해주세요.<br style="user-select: auto !important;">
결과는 부서별 평균 연봉을 기준으로 내림차순 정렬해주세요.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">예시</h5>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">HR_DEPARTMENT</code> 테이블이 다음과 같고</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">DEPT_ID</th>
<th style="user-select: auto !important;">DEPT_NAME_KR</th>
<th style="user-select: auto !important;">DEPT_NAME_EN</th>
<th style="user-select: auto !important;">LOCATION</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">D0005</td>
<td style="user-select: auto !important;">재무팀</td>
<td style="user-select: auto !important;">Finance</td>
<td style="user-select: auto !important;">그렙타워 5층</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">D0006</td>
<td style="user-select: auto !important;">구매팀</td>
<td style="user-select: auto !important;">Purchasing</td>
<td style="user-select: auto !important;">그렙타워 5층</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">D0007</td>
<td style="user-select: auto !important;">마케팅팀</td>
<td style="user-select: auto !important;">Marketing</td>
<td style="user-select: auto !important;">그렙타워 6층</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">HR_EMPLOYEES</code> 테이블이 다음과 같을 때</p>
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
<td style="user-select: auto !important;">2019003</td>
<td style="user-select: auto !important;">한동희</td>
<td style="user-select: auto !important;">D0005</td>
<td style="user-select: auto !important;">팀장</td>
<td style="user-select: auto !important;"><a href="mailto:donghee_han@grep.com" target="_blank" rel="noopener" style="user-select: auto !important;">donghee_han@grep.com</a></td>
<td style="user-select: auto !important;">031-8000-1122</td>
<td style="user-select: auto !important;">2019-03-01</td>
<td style="user-select: auto !important;">57000000</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2020032</td>
<td style="user-select: auto !important;">한명지</td>
<td style="user-select: auto !important;">D0005</td>
<td style="user-select: auto !important;">팀원</td>
<td style="user-select: auto !important;"><a href="mailto:mungji_han@grep.com" target="_blank" rel="noopener" style="user-select: auto !important;">mungji_han@grep.com</a></td>
<td style="user-select: auto !important;">031-8000-1123</td>
<td style="user-select: auto !important;">2020-03-01</td>
<td style="user-select: auto !important;">52000000</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2022003</td>
<td style="user-select: auto !important;">김보라</td>
<td style="user-select: auto !important;">D0005</td>
<td style="user-select: auto !important;">팀원</td>
<td style="user-select: auto !important;"><a href="mailto:bora_kim@grep.com" target="_blank" rel="noopener" style="user-select: auto !important;">bora_kim@grep.com</a></td>
<td style="user-select: auto !important;">031-8000-1126</td>
<td style="user-select: auto !important;">2022-03-01</td>
<td style="user-select: auto !important;">47000000</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2018005</td>
<td style="user-select: auto !important;">이재정</td>
<td style="user-select: auto !important;">D0006</td>
<td style="user-select: auto !important;">팀장</td>
<td style="user-select: auto !important;"><a href="mailto:jaejung_lee@grep.com" target="_blank" rel="noopener" style="user-select: auto !important;">jaejung_lee@grep.com</a></td>
<td style="user-select: auto !important;">031-8000-1127</td>
<td style="user-select: auto !important;">2018-03-01</td>
<td style="user-select: auto !important;">60000000</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2019032</td>
<td style="user-select: auto !important;">윤성희</td>
<td style="user-select: auto !important;">D0006</td>
<td style="user-select: auto !important;">팀원</td>
<td style="user-select: auto !important;"><a href="mailto:sunghee_yoon@grep.com" target="_blank" rel="noopener" style="user-select: auto !important;">sunghee_yoon@grep.com</a></td>
<td style="user-select: auto !important;">031-8000-1128</td>
<td style="user-select: auto !important;">2019-03-01</td>
<td style="user-select: auto !important;">57000000</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2020009</td>
<td style="user-select: auto !important;">송영섭</td>
<td style="user-select: auto !important;">D0006</td>
<td style="user-select: auto !important;">팀원</td>
<td style="user-select: auto !important;"><a href="mailto:yungseop_song@grep.com" target="_blank" rel="noopener" style="user-select: auto !important;">yungseop_song@grep.com</a></td>
<td style="user-select: auto !important;">031-8000-1130</td>
<td style="user-select: auto !important;">2020-03-01</td>
<td style="user-select: auto !important;">51000000</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2021006</td>
<td style="user-select: auto !important;">이성주</td>
<td style="user-select: auto !important;">D0006</td>
<td style="user-select: auto !important;">팀원</td>
<td style="user-select: auto !important;"><a href="mailto:sungju_lee@grep.com" target="_blank" rel="noopener" style="user-select: auto !important;">sungju_lee@grep.com</a></td>
<td style="user-select: auto !important;">031-8000-1131</td>
<td style="user-select: auto !important;">2021-03-01</td>
<td style="user-select: auto !important;">49000000</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2018004</td>
<td style="user-select: auto !important;">이주리</td>
<td style="user-select: auto !important;">D0007</td>
<td style="user-select: auto !important;">팀장</td>
<td style="user-select: auto !important;"><a href="mailto:joori_lee@grep.com" target="_blank" rel="noopener" style="user-select: auto !important;">joori_lee@grep.com</a></td>
<td style="user-select: auto !important;">031-8000-1132</td>
<td style="user-select: auto !important;">2018-03-01</td>
<td style="user-select: auto !important;">61000000</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2020012</td>
<td style="user-select: auto !important;">김사랑</td>
<td style="user-select: auto !important;">D0007</td>
<td style="user-select: auto !important;">팀원</td>
<td style="user-select: auto !important;"><a href="mailto:sarang_kim@grep.com" target="_blank" rel="noopener" style="user-select: auto !important;">sarang_kim@grep.com</a></td>
<td style="user-select: auto !important;">031-8000-1133</td>
<td style="user-select: auto !important;">2020-03-01</td>
<td style="user-select: auto !important;">54000000</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2021018</td>
<td style="user-select: auto !important;">김히라</td>
<td style="user-select: auto !important;">D0007</td>
<td style="user-select: auto !important;">팀원</td>
<td style="user-select: auto !important;"><a href="mailto:heera_kim@grep.com" target="_blank" rel="noopener" style="user-select: auto !important;">heera_kim@grep.com</a></td>
<td style="user-select: auto !important;">031-8000-1136</td>
<td style="user-select: auto !important;">2021-03-01</td>
<td style="user-select: auto !important;">49000000</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">SQL을 실행하면 다음과 같이 출력되어야 합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">DEPT_ID</th>
<th style="user-select: auto !important;">DEPT_NAME_EN</th>
<th style="user-select: auto !important;">AVG_SAL</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">D0007</td>
<td style="user-select: auto !important;">Marketing</td>
<td style="user-select: auto !important;">54666667</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">D0006</td>
<td style="user-select: auto !important;">Purchasing</td>
<td style="user-select: auto !important;">54250000</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">D0005</td>
<td style="user-select: auto !important;">Finance</td>
<td style="user-select: auto !important;">52000000</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges