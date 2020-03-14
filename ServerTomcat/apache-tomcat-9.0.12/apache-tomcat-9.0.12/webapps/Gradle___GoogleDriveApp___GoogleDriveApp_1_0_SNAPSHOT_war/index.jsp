<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Google Drive App</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  </head>
  <body style="color: red">
  <jsp:useBean id="greeting" class="Controller.Getting"/>

  <div class="container">
    <h2>Google Drive App</h2>
    <input type="submit"  style="float: right; margin-left:10px" class="btn btn-primary" value="DOWNLOAD">
    <input type="button" style="float: right;margin-left:10px" class="btn btn-primary" value="VIEW">
    <input type="submit"  style="float: right;margin-left:10px" class="btn btn-primary"  data-toggle="modal" data-target="#myModal" value="UPLOAD">
    <table class="table table-striped">
      <thead>
      <tr>
        <th>STT</th>
        <th>Tên</th>
        <th>Link source</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>1</td>
        <td>${greeting.listFile.get(0).name}</td>
        <td>${greeting.listFile.get(0).link}</td>
      </tr>
      <tr>
        <td>2</td>
        <td>${greeting.listFile.get(1).name}</td>
        <td>${greeting.listFile.get(1).link}</td>
      </tr>
      <tr>
        <td>3</td>
        <td>${greeting.listFile.get(2).name}</td>
        <td>${greeting.listFile.get(2).link}</td>
      </tr>
      <tr>
        <td>4</td>
        <td>${greeting.listFile.get(3).name}</td>
        <td>${greeting.listFile.get(3).link}</td>
      </tr> <tr>
        <td>5</td>
        <td>${greeting.listFile.get(4).name}</td>
        <td>${greeting.listFile.get(4).link}</td>
      </tr>
      <tr>
        <td>6</td>
        <td>${greeting.listFile.get(5).name}</td>
        <td>${greeting.listFile.get(5).link}</td>
      </tr>
      <tr>
        <td>7</td>
        <td>${greeting.listFile.get(6).name}</td>
        <td>${greeting.listFile.get(6).link}</td>
      </tr>
      <tr>
        <td>8</td>
        <td>${greeting.listFile.get(7).name}</td>
        <td>${greeting.listFile.get(7).link}</td>
      </tr>
      <tr>
        <td>9</td>
        <td>${greeting.listFile.get(8).name}</td>
        <td>${greeting.listFile.get(8).link}</td>
      </tr>
      <tr>
        <td>10</td>
        <td>${greeting.listFile.get(9).name}</td>
        <td>${greeting.listFile.get(9).link}</td>
      </tr>

      </tbody>
    </table>
  </div>
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <form action="/action_page.php">
            Select a file: <input type="file" name="myFile"><br><br>
            <button type="button" class="btn btn-default" >Upload</button>
          </form>
        </div>
        <div class="modal-footer">

          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>

    </div>
  </div>
  </body>
</html>
