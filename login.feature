
Feature: Employee Reisteration and timesheet

Scenario Outline: Regsiter 5 employees and create timesheet

	Given Read 5 employees from csv file and register
  And Login to each employee
  When 40 hours are entered in the timesheet for one employee
  Then the timesheet should be updated successfully
  
	