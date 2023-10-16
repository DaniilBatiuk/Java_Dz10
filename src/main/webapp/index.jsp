<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="linus-quote">Task1</a>
<h1>Знайдіть максимум із трьох чисел</h1>
<h1>Знайдіть максимум, мінімум, та середнє арифметичне із трьох чисел</h1>
<form method="post" action="max-number">
    <label for="num1">Число 1:</label>
    <input type="number" id="num1" name="num1" required><br>
    <label for="num2">Число 2:</label>
    <input type="number" id="num2" name="num2" required><br>
    <label for="num3">Число 3:</label>
    <input type="number" id="num3" name="num3" required><br>

    <input type="radio" id="max" name="operation" value="max">
    <label for="max">Максимум</label><br>
    <input type="radio" id="min" name="operation" value="min">
    <label for="min">Мінімум</label><br>
    <input type="radio" id="avg" name="operation" value="avg">
    <label for="avg">Середнє арифметичне</label><br>

    <input type="submit" value="Обчислити">
</form>
<h1>Аналіз тексту</h1>
<form method="post" action="text-analysis">
    <label for="inputText">Введіть текст:</label>
    <textarea id="inputText" name="text" rows="4" cols="50" required></textarea><br>
    <input type="submit" value="Аналізувати">
</form>
<h2>Результат аналізу тексту:</h2>
<p>Кількість голосних: <%= request.getAttribute("vowelsCount") %></p>
<p>Список голосних: <%= request.getAttribute("vowelsList") %></p>
<p>Кількість приголосних: <%= request.getAttribute("consonantsCount") %></p>
<p>Список приголосних: <%= request.getAttribute("consonantsList") %></p>
<p>Кількість розділових знаків: <%= request.getAttribute("punctuationCount") %></p>
<p>Список розділових знаків: <%= request.getAttribute("punctuationList") %></p>

<h1>Калькулятор</h1>
<form method="post" action="calculator">
    <label>Операнд 1:</label>
    <input type="text" name="operand1" required>
    <br>

    <label>Операція:</label>
    <select name="operation">
        <option value="add">Додавання</option>
        <option value="subtract">Віднімання</option>
        <option value="multiply">Множення</option>
        <option value="divide">Ділення</option>
        <option value="power">Піднесення до степеня</option>
        <option value="percentage">Відсотки</option>
    </select>
    <br>

    <label>Операнд 2:</label>
    <input type="text" name="operand2" required>
    <br>

    <input type="submit" value="Обчислити">
</form>

<c:if test="${not empty requestScope.error}">
    <p class="error">${requestScope.error}</p>
</c:if>

<c:if test="${not empty requestScope.result}">
    <p>Результат: ${requestScope.result}</p>
</c:if>
</body>
</html>