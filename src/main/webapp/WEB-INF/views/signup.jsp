<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%@ include file="/WEB-INF/views/includes.jsp" %>
	<!-- Begin Header -->
	<div id="head" >
		<!-- Includes all of the content within header.jsp-->
		<%@ include file="/WEB-INF/views/header.jsp" %>
	</div>
	<p>${serverTime}</p>
	<!-- End Header -->
<body>
<div class="container">
	<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8">
	<h1>Sign Up</h1>
	<c:if test="${not s}">
		<div>INCORRECT INFORMATION</div>
	</c:if>
	<form class="signUpForm form-horizontal" action="signup" method="POST">
		<div class="form-group">
			<label for="usr" class="col-sm-2 control-label">User Name</label>
			<div class="col-sm-6">
				<input type="text" id="usr" class="form-control" name="usr" placeholder="User Name" autofocus>
			</div>
		</div>
		<div class="form-group">
			<label for="psw" class="col-sm-2 control-label">Password</label>
			<div class="col-sm-6">
				<input type="password" id="psw" class="form-control" name="psw" placeholder="Password">
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">First Name</label>
			<div class="col-sm-6">
				<input type="text" id="name" class="form-control" name="name" placeholder="First Name">
			</div>
		</div>
		<div class="form-group">
			<label for="lstn" class="col-sm-2 control-label">Last Name</label>
			<div class="col-sm-6">
				<input type="text" id="lstn" class="form-control" name="lstn" placeholder="Last Name">
			</div>
		</div>
		<div class="form-group">
			<label for="cell" class="col-sm-2 control-label">Cell Phone Number</label>
			<div class="col-sm-6">
				<input type="text" id="cell" class="form-control" name="cell" placeholder="Cell Phone Number">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Have a car?</label>
			<div class="col-sm-6">
				<div class="btn-group" data-toggle="buttons">
					<label class="btn btn-primary">
						<input type="radio" value="Yes" id="caryes" name="caraswr"> Yes
					</label>
					<label class="btn btn-primary">
						<input type="radio" value="No" id="carno" name="caraswr"> No
					</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="model" class="col-sm-2 control-label">Model</label>
			<div class="col-sm-6">
				<input type="text" id="model" class="form-control" name="model" placeholder="Model">
			</div>
		</div>
		<div class="form-group">
			<label for="seats" class="col-sm-2 control-label">Number of Seats</label>
			<div class="col-sm-6">
				<input type="number" id="seats" class="form-control" name="seats" min="0" max="10" step="1" value="4" placeholder="Number Seats">
			</div>
		</div>
		<div class="form-group">
			<label for="desc" class="col-sm-2 control-label">Vehicle Description</label>
			<div class="col-sm-6">
				<textarea class="form-control" rows="4" id="desc" name="desc" placeholder="Vehicle Description"></textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</div>
	</form>
	</div>
	<div class="col-md-2"></div>
	</div><!-- Row End -->
	</div><!-- Container End -->
	<script>
	var phoneInput = document.getElementById('cell');
    if (phoneInput) {
      new Formatter(phoneInput, {
          'pattern': '({{999}}) {{999}}-{{9999}}'
      });
    }
    </script>
    <script>
    $(document).ready(function() {
        $('.signUpForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	usr: {
                    message: 'The username is not valid',
                    validators: {
                        notEmpty: {
                            message: 'The username is required and cannot be empty'
                        },
                        stringLength: {
                            min: 6,
                            max: 30,
                            message: 'The username must be more than 6 and less than 30 characters long'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: 'The username can only consist of alphabetical, number and underscore'
                        },
                        different: {
                            field: 'psw',
                            message: 'The username and password cannot be the same as each other'
                        }
                    }
                },
                psw: {
                    validators: {
                        notEmpty: {
                            message: 'The password is required and cannot be empty'
                        },
                        different: {
                            field: 'usr',
                            message: 'The password cannot be the same as username'
                        },
                        stringLength: {
                            min: 8,
                            message: 'The password must have at least 8 characters'
                        }
                    }
                },
                caraswr: {
                    validators: {
                        notEmpty: {
                            message: 'The vehicle selection is required'
                        }
                    }
                },
                name: {
                	validators: {
                		notEmpty: {
                			message: 'The first name is required'
                		}
                	}
                },
                lstn: {
                	validators: {
                		notEmpty: {
                			message: 'The last name is required'
                		}
                	}
                },
                cell: {
                	validators: {
                		notEmpty: {
                			message: 'The phone number is required'
                		},
                		regexp: {
                            regexp: /^\(\d{3}\)\s\d{3}-\d{4}/,
                            message: 'The phone number can only be (555) 555-5555 format'
                        },
                		
                	}
                }
            }
        });
    });
    </script>
</body>
</html>