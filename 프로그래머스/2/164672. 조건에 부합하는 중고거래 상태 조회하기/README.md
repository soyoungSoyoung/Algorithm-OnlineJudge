# [level 2] 조건에 부합하는 중고거래 상태 조회하기 - 164672 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/164672) 

### 성능 요약

메모리: 0.0 MB, 시간: 0.00 ms

### 구분

코딩테스트 연습 > String， Date

### 채점결과

Empty

### 제출 일자

2024년 09월 19일 08:42:07

### 문제 설명

<p style="user-select: auto !important;">다음은 중고거래 게시판 정보를 담은 <code style="user-select: auto !important;">USED_GOODS_BOARD</code> 테이블입니다. <code style="user-select: auto !important;">USED_GOODS_BOARD</code> 테이블은 다음과 같으며 <code style="user-select: auto !important;">BOARD_ID</code>, <code style="user-select: auto !important;">WRITER_ID</code>, <code style="user-select: auto !important;">TITLE</code>, <code style="user-select: auto !important;">CONTENTS</code>, <code style="user-select: auto !important;">PRICE</code>, <code style="user-select: auto !important;">CREATED_DATE</code>, <code style="user-select: auto !important;">STATUS</code>, <code style="user-select: auto !important;">VIEWS</code>은 게시글 ID, 작성자 ID, 게시글 제목, 게시글 내용, 가격, 작성일, 거래상태, 조회수를 의미합니다.</p>
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
<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">문제</h5>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">USED_GOODS_BOARD</code> 테이블에서 2022년 10월 5일에 등록된 중고거래 게시물의 게시글 ID, 작성자 ID, 게시글 제목, 가격, 거래상태를 조회하는 SQL문을 작성해주세요. 거래상태가 SALE 이면 판매중, RESERVED이면 예약중, DONE이면 거래완료 분류하여 출력해주시고, 결과는 게시글 ID를 기준으로 내림차순 정렬해주세요.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">예시</h5>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">USED_GOODS_BOARD</code> 테이블이 다음과 같을 때</p>
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
<td style="user-select: auto !important;">B0007</td>
<td style="user-select: auto !important;">s2s2123</td>
<td style="user-select: auto !important;">커피글라인더</td>
<td style="user-select: auto !important;">새상품처럼 깨끗합니다.</td>
<td style="user-select: auto !important;">7000</td>
<td style="user-select: auto !important;">2022-10-04</td>
<td style="user-select: auto !important;">DONE</td>
<td style="user-select: auto !important;">210</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">B0008</td>
<td style="user-select: auto !important;">hong02</td>
<td style="user-select: auto !important;">자전거 판매합니다</td>
<td style="user-select: auto !important;">출퇴근용으로 구매했다가 사용하지 않아서 내놔요</td>
<td style="user-select: auto !important;">40000</td>
<td style="user-select: auto !important;">2022-10-04</td>
<td style="user-select: auto !important;">SALE</td>
<td style="user-select: auto !important;">301</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">B0009</td>
<td style="user-select: auto !important;">yawoong67</td>
<td style="user-select: auto !important;">선반 팝니다</td>
<td style="user-select: auto !important;">6단 선반. 환불 반품 안됩니다.</td>
<td style="user-select: auto !important;">12000</td>
<td style="user-select: auto !important;">2022-10-05</td>
<td style="user-select: auto !important;">DONE</td>
<td style="user-select: auto !important;">202</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">B0010</td>
<td style="user-select: auto !important;">keel1990</td>
<td style="user-select: auto !important;">철제선반5단</td>
<td style="user-select: auto !important;">철제선반 5단 조립식 팜</td>
<td style="user-select: auto !important;">10000</td>
<td style="user-select: auto !important;">2022-10-05</td>
<td style="user-select: auto !important;">SALE</td>
<td style="user-select: auto !important;">194</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">SQL을 실행하면 다음과 같이 출력되어야 합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">BOARD_ID</th>
<th style="user-select: auto !important;">WRITER_ID</th>
<th style="user-select: auto !important;">TITLE</th>
<th style="user-select: auto !important;">PRICE</th>
<th style="user-select: auto !important;">STATUS</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">B0010</td>
<td style="user-select: auto !important;">keel1990</td>
<td style="user-select: auto !important;">철제선반5단</td>
<td style="user-select: auto !important;">10000</td>
<td style="user-select: auto !important;">판매중</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">B0009</td>
<td style="user-select: auto !important;">yawoong67</td>
<td style="user-select: auto !important;">선반 팝니다</td>
<td style="user-select: auto !important;">12000</td>
<td style="user-select: auto !important;">거래완료</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges