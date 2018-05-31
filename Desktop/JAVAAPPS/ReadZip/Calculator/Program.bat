@echo off
echo							welcome
echo.
echo What would you like to do today?

:Ask
echo 1.Multiplication
echo 2.Addition
echo 3.Subtraction
echo 4.Division
echo 5.Exit
echo.
echo.
echo Select operation:
set input=
set /p input=%=%
if "%input%"=="1" goto 1 
if "%input%"=="2" goto 2
if "%input%"=="3" goto 3
if "%input%"=="4" goto 4
if "%input%"=="5" exit
cls
echo Incorrect input
echo.
echo.
goto ask

:1
cls
color 3f
call multiply.exe
pause
cls
color 0f
goto ask
pause

:2
cls
color 1f
call addition.exe
pause
cls
color 0f
goto ask
pause

:4
cls
color fc
call division.exe
pause
cls
color 0f
goto ask
pause