# [level 3] 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기 - 151139 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/151139) 

### 성능 요약

메모리: 0.0 MB, 시간: 0.00 ms

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

Empty

### 제출 일자

2024년 09월 18일 05:08:28

### 문제 설명

<p style="user-select: auto !important;">다음은 어느 자동차 대여 회사의 자동차 대여 기록 정보를 담은 <code style="user-select: auto !important;">CAR_RENTAL_COMPANY_RENTAL_HISTORY</code> 테이블입니다. <code style="user-select: auto !important;">CAR_RENTAL_COMPANY_RENTAL_HISTORY</code> 테이블은 아래와 같은 구조로 되어있으며, <code style="user-select: auto !important;">HISTORY_ID</code>, <code style="user-select: auto !important;">CAR_ID</code>, <code style="user-select: auto !important;">START_DATE</code>, <code style="user-select: auto !important;">END_DATE</code> 는 각각 자동차 대여 기록 ID, 자동차 ID, 대여 시작일, 대여 종료일을 나타냅니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">Column name</th>
<th style="user-select: auto !important;">Type</th>
<th style="user-select: auto !important;">Nullable</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">HISTORY_ID</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">CAR_ID</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">START_DATE</td>
<td style="user-select: auto !important;">DATE</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">END_DATE</td>
<td style="user-select: auto !important;">DATE</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">문제</h5>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">CAR_RENTAL_COMPANY_RENTAL_HISTORY</code> 테이블에서 대여 시작일을 기준으로 2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회 이상인 자동차들에 대해서 해당 기간 동안의 월별 자동차 ID 별 총 대여 횟수(컬럼명: <code style="user-select: auto !important;">RECORDS</code>) 리스트를 출력하는 SQL문을 작성해주세요. 결과는 월을 기준으로 오름차순 정렬하고, 월이 같다면 자동차 ID를 기준으로 내림차순 정렬해주세요. 특정 월의 총 대여 횟수가 0인 경우에는 결과에서 제외해주세요.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">예시</h5>

<p style="user-select: auto !important;">예를 들어 <code style="user-select: auto !important;">CAR_RENTAL_COMPANY_RENTAL_HISTORY</code> 테이블이 다음과 같다면</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">HISTORY_ID</th>
<th style="user-select: auto !important;">CAR_ID</th>
<th style="user-select: auto !important;">START_DATE</th>
<th style="user-select: auto !important;">END_DATE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">2022-07-27</td>
<td style="user-select: auto !important;">2022-08-02</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">2022-08-03</td>
<td style="user-select: auto !important;">2022-08-04</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">2022-08-05</td>
<td style="user-select: auto !important;">2022-08-05</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">4</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">2022-08-09</td>
<td style="user-select: auto !important;">2022-08-12</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">5</td>
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">2022-09-16</td>
<td style="user-select: auto !important;">2022-10-15</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">6</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">2022-08-24</td>
<td style="user-select: auto !important;">2022-08-30</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">7</td>
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">2022-10-16</td>
<td style="user-select: auto !important;">2022-10-19</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">8</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">2022-09-03</td>
<td style="user-select: auto !important;">2022-09-07</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">9</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">2022-09-18</td>
<td style="user-select: auto !important;">2022-09-19</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">10</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">2022-09-08</td>
<td style="user-select: auto !important;">2022-09-10</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">11</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">2022-10-16</td>
<td style="user-select: auto !important;">2022-10-19</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">12</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">2022-09-29</td>
<td style="user-select: auto !important;">2022-10-06</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">13</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">2022-10-30</td>
<td style="user-select: auto !important;">2022-11-01</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">14</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">2022-11-05</td>
<td style="user-select: auto !important;">2022-11-05</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">15</td>
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">2022-11-11</td>
<td style="user-select: auto !important;">2022-11-11</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">대여 시작일을 기준으로 총 대여 횟수가 5회 이상인 자동차는 자동차 ID가 1, 2인 자동차입니다. 월 별 자동차 ID별 총 대여 횟수를 구하고 월 오름차순, 자동차 ID 내림차순으로 정렬하면 다음과 같이 나와야 합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">MONTH</th>
<th style="user-select: auto !important;">CAR_ID</th>
<th style="user-select: auto !important;">RECORDS</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">8</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">2</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">8</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">2</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">9</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">1</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">9</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">3</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">10</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">2</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges