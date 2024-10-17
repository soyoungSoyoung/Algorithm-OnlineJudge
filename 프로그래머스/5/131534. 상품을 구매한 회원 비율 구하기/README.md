# [level 5] 상품을 구매한 회원 비율 구하기 - 131534 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131534) 

### 성능 요약

메모리: 0.0 MB, 시간: 0.00 ms

### 구분

코딩테스트 연습 > JOIN

### 채점결과

Empty

### 제출 일자

2024년 10월 17일 13:05:44

### 문제 설명

<p style="user-select: auto !important;">다음은 어느 의류 쇼핑몰에 가입한 회원 정보를 담은 <code style="user-select: auto !important;">USER_INFO</code> 테이블과 온라인 상품 판매 정보를 담은 <code style="user-select: auto !important;">ONLINE_SALE</code> 테이블 입니다. <code style="user-select: auto !important;">USER_INFO</code> 테이블은 아래와 같은 구조로 되어있으며 <code style="user-select: auto !important;">USER_ID</code>, <code style="user-select: auto !important;">GENDER</code>, <code style="user-select: auto !important;">AGE</code>, <code style="user-select: auto !important;">JOINED</code>는 각각 회원 ID, 성별, 나이, 가입일을 나타냅니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">Column name</th>
<th style="user-select: auto !important;">Type</th>
<th style="user-select: auto !important;">Nullable</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">USER_ID</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">GENDER</td>
<td style="user-select: auto !important;">TINYINT(1)</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">AGE</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">JOINED</td>
<td style="user-select: auto !important;">DATE</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">GENDER</code> 컬럼은 비어있거나 0 또는 1의 값을 가지며 0인 경우 남자를, 1인 경우는 여자를 나타냅니다.</p>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">ONLINE_SALE</code> 테이블은 아래와 같은 구조로 되어있으며 <code style="user-select: auto !important;">ONLINE_SALE_ID</code>, <code style="user-select: auto !important;">USER_ID</code>, <code style="user-select: auto !important;">PRODUCT_ID</code>, <code style="user-select: auto !important;">SALES_AMOUNT</code>, <code style="user-select: auto !important;">SALES_DATE</code>는 각각 온라인 상품 판매 ID, 회원 ID, 상품 ID, 판매량, 판매일을 나타냅니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">Column name</th>
<th style="user-select: auto !important;">Type</th>
<th style="user-select: auto !important;">Nullable</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">ONLINE_SALE_ID</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">USER_ID</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">PRODUCT_ID</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">SALES_AMOUNT</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">SALES_DATE</td>
<td style="user-select: auto !important;">DATE</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">동일한 날짜, 회원 ID, 상품 ID 조합에 대해서는 하나의 판매 데이터만 존재합니다.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">문제</h5>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">USER_INFO</code> 테이블과 <code style="user-select: auto !important;">ONLINE_SALE</code> 테이블에서 2021년에 가입한 전체 회원들 중 상품을 구매한 회원수와 상품을 구매한 회원의 비율(=2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수)을 년, 월 별로 출력하는 SQL문을 작성해주세요. 상품을 구매한 회원의 비율은 소수점 두번째자리에서 반올림하고, 전체 결과는 년을 기준으로 오름차순 정렬해주시고 년이 같다면 월을 기준으로 오름차순 정렬해주세요.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">예시</h5>

<p style="user-select: auto !important;">예를 들어 <code style="user-select: auto !important;">USER_INFO</code> 테이블이 다음과 같고 </p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">USER_ID</th>
<th style="user-select: auto !important;">GENDER</th>
<th style="user-select: auto !important;">AGE</th>
<th style="user-select: auto !important;">JOINED</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">26</td>
<td style="user-select: auto !important;">2021-06-01</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">NULL</td>
<td style="user-select: auto !important;">NULL</td>
<td style="user-select: auto !important;">2021-06-25</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">0</td>
<td style="user-select: auto !important;">NULL</td>
<td style="user-select: auto !important;">2021-06-30</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">4</td>
<td style="user-select: auto !important;">0</td>
<td style="user-select: auto !important;">31</td>
<td style="user-select: auto !important;">2021-07-03</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">5</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">25</td>
<td style="user-select: auto !important;">2022-01-09</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">6</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">33</td>
<td style="user-select: auto !important;">2022-02-14</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">ONLINE_SALE</code> 이 다음과 같다면</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">ONLINE_SALE_ID</th>
<th style="user-select: auto !important;">USER_ID</th>
<th style="user-select: auto !important;">PRODUCT_ID</th>
<th style="user-select: auto !important;">SALES_AMOUNT</th>
<th style="user-select: auto !important;">SALES_DATE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">54</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">2022-01-01</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">2022-01-25</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">4</td>
<td style="user-select: auto !important;">34</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">2022-01-30</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">4</td>
<td style="user-select: auto !important;">6</td>
<td style="user-select: auto !important;">253</td>
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">2022-02-03</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">5</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">31</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">2022-02-09</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">6</td>
<td style="user-select: auto !important;">5</td>
<td style="user-select: auto !important;">35</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">2022-02-14</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">7</td>
<td style="user-select: auto !important;">5</td>
<td style="user-select: auto !important;">57</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">2022-02-18</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">2021년에 가입한 회원은 <code style="user-select: auto !important;">USER_ID</code>가 1, 2, 3, 4 인 회원들로 총 4명 입니다. <code style="user-select: auto !important;">ONLINE_SALE</code> 테이블에서 해당 회원들에 대한 판매 데이터는 다음과 같습니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">ONLINE_SALE_ID</th>
<th style="user-select: auto !important;">USER_ID</th>
<th style="user-select: auto !important;">PRODUCT_ID</th>
<th style="user-select: auto !important;">SALES_AMOUNT</th>
<th style="user-select: auto !important;">SALES_DATE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">54</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">2022-01-01</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">2022-01-25</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">4</td>
<td style="user-select: auto !important;">34</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">2022-01-30</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">5</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">31</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">2022-02-09</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">그러므로 년, 월 별로 상품을 구매한 회원수와 상품을 구매한 회원의 비율을 구하고 결과를 정렬하면 다음과 같아야 합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">YEAR</th>
<th style="user-select: auto !important;">MONTH</th>
<th style="user-select: auto !important;">PURCHASED_USERS</th>
<th style="user-select: auto !important;">PUCHASED_RATIO</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2022</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">0.5</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2022</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">0.3</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges