
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */



def static "com.test.myindihome.Register.registerFlow"(
    	Object Input_Fullname	
     , 	Object Input_Ponsel	
     , 	Object Input_Email	
     , 	Object Input_Password	) {
    (new com.test.myindihome.Register()).registerFlow(
        	Input_Fullname
         , 	Input_Ponsel
         , 	Input_Email
         , 	Input_Password)
}


def static "com.test.myindihome.Register.registerCondition"(
    	Object Negative_Case	
     , 	Object Select_Activation	
     , 	Object OTP1	
     , 	Object OTP2	
     , 	Object OTP3	
     , 	Object OTP4	
     , 	Object Message	) {
    (new com.test.myindihome.Register()).registerCondition(
        	Negative_Case
         , 	Select_Activation
         , 	OTP1
         , 	OTP2
         , 	OTP3
         , 	OTP4
         , 	Message)
}


def static "com.test.myindihome.Register.registerMetodeAktivasi"(
    	Object Select_Activation	
     , 	Object OTP1	
     , 	Object OTP2	
     , 	Object OTP3	
     , 	Object OTP4	) {
    (new com.test.myindihome.Register()).registerMetodeAktivasi(
        	Select_Activation
         , 	OTP1
         , 	OTP2
         , 	OTP3
         , 	OTP4)
}


def static "com.test.myindihome.Login.loginFlow"(
    	Object Input_Email_Phone	
     , 	Object Input_Password	) {
    (new com.test.myindihome.Login()).loginFlow(
        	Input_Email_Phone
         , 	Input_Password)
}


def static "com.test.myindihome.Login.loginCondition"(
    	Object Negative_Case	
     , 	Object Select_Activation	
     , 	Object OTP1	
     , 	Object OTP2	
     , 	Object OTP3	
     , 	Object OTP4	
     , 	Object Message	) {
    (new com.test.myindihome.Login()).loginCondition(
        	Negative_Case
         , 	Select_Activation
         , 	OTP1
         , 	OTP2
         , 	OTP3
         , 	OTP4
         , 	Message)
}


def static "com.test.myindihome.Login.loginMetodeAktivasi"(
    	Object Select_Activation	
     , 	Object OTP1	
     , 	Object OTP2	
     , 	Object OTP3	
     , 	Object OTP4	) {
    (new com.test.myindihome.Login()).loginMetodeAktivasi(
        	Select_Activation
         , 	OTP1
         , 	OTP2
         , 	OTP3
         , 	OTP4)
}
