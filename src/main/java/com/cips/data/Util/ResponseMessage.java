package com.cips.data.Util;

 public class ResponseMessage {

   private String status;

   private String message;

   private Object data;
   
   public void setStatus(String status) { this.status = status; } public void setMessage(String message) { this.message = message; } public void setData(Object data) { this.data = data; } public boolean equals(Object o) { if (o == this) return true; if (!(o instanceof ResponseMessage)) return false; ResponseMessage other = (ResponseMessage)o; if (!other.canEqual(this)) return false; Object this$status = getStatus();Object other$status = other.getStatus(); if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false; Object this$message = getMessage();Object other$message = other.getMessage(); if (this$message == null ? other$message != null : !this$message.equals(other$message)) return false; Object this$data = getData();Object other$data = other.getData();return this$data == null ? other$data == null : this$data.equals(other$data); } protected boolean canEqual(Object other) { return other instanceof ResponseMessage; } public int hashCode() { int PRIME = 59;int result = 1;Object $status = getStatus();result = result * 59 + ($status == null ? 43 : $status.hashCode());Object $message = getMessage();result = result * 59 + ($message == null ? 43 : $message.hashCode());Object $data = getData();result = result * 59 + ($data == null ? 43 : $data.hashCode());return result; } public String toString() { return "ResponseMessage(status=" + getStatus() + ", message=" + getMessage() + ", data=" + getData() + ")"; }
 
   public String getStatus() { return status; }
   public String getMessage() { return message; }
   public Object getData() { return data; }

  // public string getstatus(){return status;}

   public static ResponseMessage ok()
   {
     return create("0", null, null);
   }
   //public static com.example.demo.Util.ResponseMessage fail(){return create (status:"0",message:null,data:null);}
 
   public static ResponseMessage ok(String message)
   {
     return create("0", message, null);
   }

 
   public static <T> ResponseMessage ok(String message, T data)
   {
     return create("0", message, data);
   }
   


   public static <T> ResponseMessage ok(T data)
   {
     return create("0", null, data);
   }
   
 

   public static ResponseMessage error(String code, String s)
   {
     return create("1", null, null);
   }
   
 

   public static ResponseMessage error(String message)
   {
    return create("1", message, null);
   }



   private static ResponseMessage create(String status, String message, Object data) {
     ResponseMessage t = new ResponseMessage();
     t.setStatus(status);
     t.setMessage(message);
     t.setData(data);
     return t;
   }

 }
