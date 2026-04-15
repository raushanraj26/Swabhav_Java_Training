-- 1. List all countries along with their region names.
Select c.COUNTRY_ID,c.COUNTRY_NAME,c.REGION_ID,r.REGION_NAME 
from countries as c
join regions as r
on c.REGION_ID=r.REGION_ID;

-- 2. List all locations along with their country names.
Select l.LOCATION_ID,l.STREET_ADDRESS,l.POSTAL_CODE,l.CITY,l.STATE_PROVINCE,l.COUNTRY_ID,c.COUNTRY_NAME
 from locations as l
join countries as c
on l.COUNTRY_ID=c.COUNTRY_ID;

-- 3. Find all regions, including those without any countries.
                    -- a.inner join-return only matching data but
                    -- b. left join -return all data from left table and matching data as well,fill with null
Select r.REGION_ID,r.REGION_NAME,c.COUNTRY_ID,c.COUNTRY_NAME
From regions r
LEFT JOIN countries c
ON r.REGION_ID = c.REGION_ID;


-- 4. Find all countries, including those without any locations.
select  c.COUNTRY_ID,c.COUNTRY_NAME,c.REGION_ID,l.LOCATION_ID,l.STREET_ADDRESS,l.POSTAL_CODE,l.CITY,l.STATE_PROVINCE
from countries c
left join locations l
on l.COUNTRY_ID=c.COUNTRY_ID;


-- 5. Get the count of countries in each region.
select r.REGION_ID,r.REGION_NAME ,COUNT(c.COUNTRY_NAME) AS CountriesCount
from regions as r
join countries as c
on r.REGION_ID=c.REGION_ID
Group by r.REGION_NAME,r.REGION_ID;






-- Get the count of locations in each country.
select c.COUNTRY_ID,c.COUNTRY_NAME,c.REGION_ID,COUNT(l.LOCATION_ID) as LocationCount
FROM countries as c
join locations as l
on c.COUNTRY_ID=l.COUNTRY_ID
group by c.COUNTRY_ID,c.COUNTRY_NAME,c.REGION_ID;


-- List regions that have more than 5 countries.
select r.REGION_ID,r.REGION_NAME,COUNT(c.COUNTRY_ID) AS COUNTCOUNTRY
FROM regions r
join countries c
on r.REGION_ID=c.REGION_ID
group by r.REGION_ID,r.REGION_NAME
having COUNTCOUNTRY>5;










-- Find all cities with their country and region names.
-- List all countries that do not have any locations.
-- List the region name, country name, and the number of locations per country.
--  
--  
--  
-- Which countries are located in the "Asia" region?
-- List the names of all countries in the "Americas" region that have at least one location.
-- Find all cities in the "Europe" region along with their respective country names.
-- How many countries are in the "Middle East and Asia" region?
-- List all regions along with the number of countries in each region.
-- Which countries do not have any associated locations?
-- Find all countries along with their region names, where the region name is either "Europe" or "Asia".
-- List all locations in "Italy" along with the city and postal code.
-- Which countries have more than one location?
-- Retrieve all locations in "Canada" and the United States along with the state/province information.
