# [level 3] 조건에 맞는 사용자와 총 거래금액 조회하기 - 164668 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/164668) 

### 성능 요약

메모리: 0.0 MB, 시간: 0.00 ms

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

Empty

### 제출 일자

2024년 09월 25일 20:32:37

### 문제 설명

<p style="user-select: auto !important;">다음은 중고 거래 게시판 정보를 담은 <code style="user-select: auto !important;">USED_GOODS_BOARD</code> 테이블과 중고 거래 게시판 사용자 정보를 담은 <code style="user-select: auto !important;">USED_GOODS_USER</code> 테이블입니다. <code style="user-select: auto !important;">USED_GOODS_BOARD</code> 테이블은 다음과 같으며 <code style="user-select: auto !important;">BOARD_ID</code>, <code style="user-select: auto !important;">WRITER_ID</code>, <code style="user-select: auto !important;">TITLE</code>, <code style="user-select: auto !important;">CONTENTS</code>, <code style="user-select: auto !important;">PRICE</code>, <code style="user-select: auto !important;">CREATED_DATE</code>, <code style="user-select: auto !important;">STATUS</code>, <code style="user-select: auto !important;">VIEWS</code>는 게시글 ID, 작성자 ID, 게시글 제목, 게시글 내용, 가격, 작성일, 거래상태, 조회수를 의미합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">Column name</th>
<th style="user-select: auto !important;">Type</th>
<th style="user-select: auto !important;">Nullable</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">BOARD_ID</td>
<td style="user-select: auto !important;">VARCHAR(5)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">WRITER_ID</td>
<td style="user-select: auto !important;">VARCHAR(50)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">TITLE</td>
<td style="user-select: auto !important;">VARCHAR(100)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">CONTENTS</td>
<td style="user-select: auto !important;">VARCHAR(1000)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">PRICE</td>
<td style="user-select: auto !important;">NUMBER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">CREATED_DATE</td>
<td style="user-select: auto !important;">DATE</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">STATUS</td>
<td style="user-select: auto !important;">VARCHAR(10)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">VIEWS</td>
<td style="user-select: auto !important;">NUMBER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">USED_GOODS_USER</code> 테이블은 다음과 같으며 <code style="user-select: auto !important;">USER_ID</code>, <code style="user-select: auto !important;">NICKNAME</code>, <code style="user-select: auto !important;">CITY</code>, <code style="user-select: auto !important;">STREET_ADDRESS1</code>, <code style="user-select: auto !important;">STREET_ADDRESS2</code>, <code style="user-select: auto !important;">TLNO</code>는 각각 회원 ID, 닉네임, 시, 도로명 주소, 상세 주소, 전화번호를 를 의미합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">Column name</th>
<th style="user-select: auto !important;">Type</th>
<th style="user-select: auto !important;">Nullable</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">USER_ID</td>
<td style="user-select: auto !important;">VARCHAR(50)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">NICKANME</td>
<td style="user-select: auto !important;">VARCHAR(100)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">CITY</td>
<td style="user-select: auto !important;">VARCHAR(100)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">STREET_ADDRESS1</td>
<td style="user-select: auto !important;">VARCHAR(100)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">STREET_ADDRESS2</td>
<td style="user-select: auto !important;">VARCHAR(100)</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">TLNO</td>
<td style="user-select: auto !important;">VARCHAR(20)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">문제</h5>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">USED_GOODS_BOARD</code>와 <code style="user-select: auto !important;">USED_GOODS_USER</code> 테이블에서 완료된 중고 거래의 총금액이 70만 원 이상인 사람의 회원 ID, 닉네임, 총거래금액을 조회하는 SQL문을 작성해주세요. 결과는 총거래금액을 기준으로 오름차순 정렬해주세요.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">예시</h5>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">USED_GOODS_BOARD</code> 테이블이 다음과 같고</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">BOARD_ID</th>
<th style="user-select: auto !important;">WRITER_ID</th>
<th style="user-select: auto !important;">TITLE</th>
<th style="user-select: auto !important;">CONTENTS</th>
<th style="user-select: auto !important;">PRICE</th>
<th style="user-select: auto !important;">CREATED_DATE</th>
<th style="user-select: auto !important;">STATUS</th>
<th style="user-select: auto !important;">VIEWS</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">B0001</td>
<td style="user-select: auto !important;">zkzkdh1</td>
<td style="user-select: auto !important;">캠핑의자</td>
<td style="user-select: auto !important;">가벼워요 깨끗한 상태입니다. 2개</td>
<td style="user-select: auto !important;">25000</td>
<td style="user-select: auto !important;">2022-11-29</td>
<td style="user-select: auto !important;">SALE</td>
<td style="user-select: auto !important;">34</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">B0002</td>
<td style="user-select: auto !important;">miyeon89</td>
<td style="user-select: auto !important;">벽걸이 에어컨</td>
<td style="user-select: auto !important;">엘지 휘센 7평</td>
<td style="user-select: auto !important;">100000</td>
<td style="user-select: auto !important;">2022-11-29</td>
<td style="user-select: auto !important;">SALE</td>
<td style="user-select: auto !important;">55</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">B0003</td>
<td style="user-select: auto !important;">dhfkzmf09</td>
<td style="user-select: auto !important;">에어팟 맥스</td>
<td style="user-select: auto !important;">에어팟 맥스 스카이 블루 색상 판매합니다.</td>
<td style="user-select: auto !important;">450000</td>
<td style="user-select: auto !important;">2022-11-26</td>
<td style="user-select: auto !important;">DONE</td>
<td style="user-select: auto !important;">67</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">B0004</td>
<td style="user-select: auto !important;">sangjune1</td>
<td style="user-select: auto !important;">파파야나인 포르쉐 푸쉬카</td>
<td style="user-select: auto !important;">예민하신분은 피해주세요</td>
<td style="user-select: auto !important;">30000</td>
<td style="user-select: auto !important;">2022-11-30</td>
<td style="user-select: auto !important;">DONE</td>
<td style="user-select: auto !important;">78</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">B0005</td>
<td style="user-select: auto !important;">zkzkdh1</td>
<td style="user-select: auto !important;">애플워치7</td>
<td style="user-select: auto !important;">애플워치7 실버 스텐 45미리 판매합니다.</td>
<td style="user-select: auto !important;">700000</td>
<td style="user-select: auto !important;">2022-11-30</td>
<td style="user-select: auto !important;">DONE</td>
<td style="user-select: auto !important;">99</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">USED_GOODS_USER</code> 테이블이 다음과 같을 때</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">USER_ID</th>
<th style="user-select: auto !important;">NICKNAME</th>
<th style="user-select: auto !important;">CITY</th>
<th style="user-select: auto !important;">STREET_ADDRESS1</th>
<th style="user-select: auto !important;">STREET_ADDRESS2</th>
<th style="user-select: auto !important;">TLNO</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">cjfwls91</td>
<td style="user-select: auto !important;">점심만금식</td>
<td style="user-select: auto !important;">성남시</td>
<td style="user-select: auto !important;">분당구 내정로 185</td>
<td style="user-select: auto !important;">501호</td>
<td style="user-select: auto !important;">01036344964</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">zkzkdh1</td>
<td style="user-select: auto !important;">후후후</td>
<td style="user-select: auto !important;">성남시</td>
<td style="user-select: auto !important;">분당구 내정로 35</td>
<td style="user-select: auto !important;">가동 1202호</td>
<td style="user-select: auto !important;">01032777543</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">spdlqj12</td>
<td style="user-select: auto !important;">크크큭</td>
<td style="user-select: auto !important;">성남시</td>
<td style="user-select: auto !important;">분당구 수내로 206</td>
<td style="user-select: auto !important;">2019동 801호</td>
<td style="user-select: auto !important;">01087234922</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">xlqpfh2</td>
<td style="user-select: auto !important;">잉여킹</td>
<td style="user-select: auto !important;">성남시</td>
<td style="user-select: auto !important;">분당구 수내로 1</td>
<td style="user-select: auto !important;">001-004</td>
<td style="user-select: auto !important;">01064534911</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">dhfkzmf09</td>
<td style="user-select: auto !important;">찐찐</td>
<td style="user-select: auto !important;">성남시</td>
<td style="user-select: auto !important;">분당구 수내로 13</td>
<td style="user-select: auto !important;">A동 1107호</td>
<td style="user-select: auto !important;">01053422914</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">SQL을 실행하면 다음과 같이 출력되어야 합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">USER_ID</th>
<th style="user-select: auto !important;">NICKNAME</th>
<th style="user-select: auto !important;">TOTAL_SALES</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">zkzkdh1</td>
<td style="user-select: auto !important;">후후후</td>
<td style="user-select: auto !important;">700000</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges