# [level 4] 취소되지 않은 진료 예약 조회하기 - 132204 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/132204) 

### 성능 요약

메모리: 0.0 MB, 시간: 0.00 ms

### 구분

코딩테스트 연습 > String， Date

### 채점결과

Empty

### 제출 일자

2024년 10월 02일 23:39:17

### 문제 설명

<p style="user-select: auto !important;">다음은 환자 정보를 담은 <code style="user-select: auto !important;">PATIENT</code> 테이블과 의사 정보를 담은 <code style="user-select: auto !important;">DOCTOR</code> 테이블, 그리고 진료 예약목록을 담은 <code style="user-select: auto !important;">APPOINTMENT</code>에 대한 테이블입니다. <code style="user-select: auto !important;">PATIENT</code> 테이블은 다음과 같으며 <code style="user-select: auto !important;">PT_NO</code>, <code style="user-select: auto !important;">PT_NAME</code>, <code style="user-select: auto !important;">GEND_CD</code>, <code style="user-select: auto !important;">AGE</code>, <code style="user-select: auto !important;">TLNO</code>는 각각 환자번호, 환자이름, 성별코드, 나이, 전화번호를 의미합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">Column name</th>
<th style="user-select: auto !important;">Type</th>
<th style="user-select: auto !important;">Nullable</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">PT_NO</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">PT_NAME</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">GEND_CD</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">AGE</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">TLNO</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">DOCTOR</code> 테이블은 다음과 같으며 <code style="user-select: auto !important;">DR_NAME</code>, <code style="user-select: auto !important;">DR_ID</code>, <code style="user-select: auto !important;">LCNS_NO</code>, <code style="user-select: auto !important;">HIRE_YMD</code>, <code style="user-select: auto !important;">MCDP_CD</code>, <code style="user-select: auto !important;">TLNO</code>는 각각 의사이름, 의사ID, 면허번호, 고용일자, 진료과코드, 전화번호를 나타냅니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">Column name</th>
<th style="user-select: auto !important;">Type</th>
<th style="user-select: auto !important;">Nullable</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">DR_NAME</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">DR_ID</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">LCNS_NO</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">HIRE_YMD</td>
<td style="user-select: auto !important;">DATE</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">MCDP_CD</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">TLNO</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">APPOINTMENT</code> 테이블은 다음과 같으며 <code style="user-select: auto !important;">APNT_YMD</code>, <code style="user-select: auto !important;">APNT_NO</code>, <code style="user-select: auto !important;">PT_NO</code>, <code style="user-select: auto !important;">MCDP_CD</code>, <code style="user-select: auto !important;">MDDR_ID</code>, <code style="user-select: auto !important;">APNT_CNCL_YN</code>, <code style="user-select: auto !important;">APNT_CNCL_YMD</code>는 각각 진료 예약일시, 진료예약번호, 환자번호, 진료과코드, 의사ID, 예약취소여부, 예약취소날짜를 나타냅니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">Column name</th>
<th style="user-select: auto !important;">Type</th>
<th style="user-select: auto !important;">Nullable</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">APNT_YMD</td>
<td style="user-select: auto !important;">TIMESTAMP</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">APNT_NO</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">PT_NO</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">MCDP_CD</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">MDDR_ID</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">APNT_CNCL_YN</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">APNT_CNCL_YMD</td>
<td style="user-select: auto !important;">DATE</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">문제</h5>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">PATIENT</code>, <code style="user-select: auto !important;">DOCTOR</code> 그리고 <code style="user-select: auto !important;">APPOINTMENT</code> 테이블에서 2022년 4월 13일 취소되지 않은 흉부외과(CS) 진료 예약 내역을 조회하는 SQL문을 작성해주세요. 진료예약번호, 환자이름, 환자번호, 진료과코드, 의사이름, 진료예약일시 항목이 출력되도록 작성해주세요. 결과는 진료예약일시를 기준으로 오름차순 정렬해주세요.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">예시</h5>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">PATIENT</code> 테이블이 다음과 같고,</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">PT_NO</th>
<th style="user-select: auto !important;">PT_NAME</th>
<th style="user-select: auto !important;">GEND_CD</th>
<th style="user-select: auto !important;">AGE</th>
<th style="user-select: auto !important;">TLNO</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">PT22000019</td>
<td style="user-select: auto !important;">바라</td>
<td style="user-select: auto !important;">W</td>
<td style="user-select: auto !important;">10</td>
<td style="user-select: auto !important;">01079068799</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">PT22000043</td>
<td style="user-select: auto !important;">오스왈드</td>
<td style="user-select: auto !important;">M</td>
<td style="user-select: auto !important;">68</td>
<td style="user-select: auto !important;">01031294124</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">PT22000052</td>
<td style="user-select: auto !important;">제니</td>
<td style="user-select: auto !important;">W</td>
<td style="user-select: auto !important;">60</td>
<td style="user-select: auto !important;">NULL</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">PT22000071</td>
<td style="user-select: auto !important;">몬몬</td>
<td style="user-select: auto !important;">M</td>
<td style="user-select: auto !important;">31</td>
<td style="user-select: auto !important;">01076489209</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">PT22000097</td>
<td style="user-select: auto !important;">슈가</td>
<td style="user-select: auto !important;">M</td>
<td style="user-select: auto !important;">19</td>
<td style="user-select: auto !important;">NULL</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">DOCTOR</code> 테이블이 다음과 같고,</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">DR_NAME</th>
<th style="user-select: auto !important;">DR_ID</th>
<th style="user-select: auto !important;">LCNS_NO</th>
<th style="user-select: auto !important;">HIRE_YMD</th>
<th style="user-select: auto !important;">MCDP_CD</th>
<th style="user-select: auto !important;">TLNO</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">루피</td>
<td style="user-select: auto !important;">DR20090029</td>
<td style="user-select: auto !important;">LC00010001</td>
<td style="user-select: auto !important;">2009-03-01</td>
<td style="user-select: auto !important;">CS</td>
<td style="user-select: auto !important;">01085482011</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">니모</td>
<td style="user-select: auto !important;">DR20200012</td>
<td style="user-select: auto !important;">LC00911162</td>
<td style="user-select: auto !important;">2020-03-01</td>
<td style="user-select: auto !important;">CS</td>
<td style="user-select: auto !important;">01089483921</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">핑크퐁</td>
<td style="user-select: auto !important;">DR20140011</td>
<td style="user-select: auto !important;">LC00082201</td>
<td style="user-select: auto !important;">2014-03-01</td>
<td style="user-select: auto !important;">NP</td>
<td style="user-select: auto !important;">01098428957</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">젤라비</td>
<td style="user-select: auto !important;">DR20160031</td>
<td style="user-select: auto !important;">LC00340327</td>
<td style="user-select: auto !important;">2016-11-01</td>
<td style="user-select: auto !important;">OB</td>
<td style="user-select: auto !important;">01023981922</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">토리</td>
<td style="user-select: auto !important;">DR20190129</td>
<td style="user-select: auto !important;">LC00099911</td>
<td style="user-select: auto !important;">2019-03-01</td>
<td style="user-select: auto !important;">NS</td>
<td style="user-select: auto !important;">01058390758</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">APPOINTMENT</code> 테이블이 다음과 같을 때,</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">APNT_YMD</th>
<th style="user-select: auto !important;">APNT_NO</th>
<th style="user-select: auto !important;">PT_NO</th>
<th style="user-select: auto !important;">MCDP_CD</th>
<th style="user-select: auto !important;">MDDR_ID</th>
<th style="user-select: auto !important;">APNT_CNCL_YN</th>
<th style="user-select: auto !important;">APNT_CNCL_YMD</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2022-04-13 12:30:00.000000</td>
<td style="user-select: auto !important;">42</td>
<td style="user-select: auto !important;">PT22000071</td>
<td style="user-select: auto !important;">CS</td>
<td style="user-select: auto !important;">DR20090029</td>
<td style="user-select: auto !important;">N</td>
<td style="user-select: auto !important;">NULL</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2022-04-13 15:30:00.000000</td>
<td style="user-select: auto !important;">43</td>
<td style="user-select: auto !important;">PT22000019</td>
<td style="user-select: auto !important;">CS</td>
<td style="user-select: auto !important;">DR20200012</td>
<td style="user-select: auto !important;">N</td>
<td style="user-select: auto !important;">NULL</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2022-04-13 09:00:00.000000</td>
<td style="user-select: auto !important;">46</td>
<td style="user-select: auto !important;">PT22000043</td>
<td style="user-select: auto !important;">CS</td>
<td style="user-select: auto !important;">DR20090029</td>
<td style="user-select: auto !important;">N</td>
<td style="user-select: auto !important;">NULL</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2022-07-09 11:00:00.000000</td>
<td style="user-select: auto !important;">74</td>
<td style="user-select: auto !important;">PT22000042</td>
<td style="user-select: auto !important;">NP</td>
<td style="user-select: auto !important;">DR20100011</td>
<td style="user-select: auto !important;">N</td>
<td style="user-select: auto !important;">NULL</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2022-12-13 12:30:00.000000</td>
<td style="user-select: auto !important;">110</td>
<td style="user-select: auto !important;">PT22000097</td>
<td style="user-select: auto !important;">NP</td>
<td style="user-select: auto !important;">DR20160011</td>
<td style="user-select: auto !important;">Y</td>
<td style="user-select: auto !important;">2022-12-03</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">SQL을 실행하면 다음과 같이 출력되어야 합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">APNT_NO</th>
<th style="user-select: auto !important;">PT_NAME</th>
<th style="user-select: auto !important;">PT_NO</th>
<th style="user-select: auto !important;">MCDP_CD</th>
<th style="user-select: auto !important;">DR_NAME</th>
<th style="user-select: auto !important;">APNT_YMD</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">46</td>
<td style="user-select: auto !important;">오스왈드</td>
<td style="user-select: auto !important;">PT22000043</td>
<td style="user-select: auto !important;">CS</td>
<td style="user-select: auto !important;">루피</td>
<td style="user-select: auto !important;">2022-04-13 09:00:00.000000</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">42</td>
<td style="user-select: auto !important;">몬몬</td>
<td style="user-select: auto !important;">PT22000071</td>
<td style="user-select: auto !important;">CS</td>
<td style="user-select: auto !important;">루피</td>
<td style="user-select: auto !important;">2022-04-13 12:30:00.000000</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">43</td>
<td style="user-select: auto !important;">바라</td>
<td style="user-select: auto !important;">PT22000019</td>
<td style="user-select: auto !important;">CS</td>
<td style="user-select: auto !important;">니모</td>
<td style="user-select: auto !important;">2022-04-13 15:30:00.000000</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges