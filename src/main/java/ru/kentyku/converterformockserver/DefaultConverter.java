package ru.kentyku.converterformockserver;

public class DefaultConverter implements Converter {

    @Override
    public String convert(String text) {

//        return getPortString(text, "Mock Server Configuration:");
        return "<html>" +
                "<body>" +

                "&ltbackend.mock.application.configurer.port&gt"+getPortString(text, "Mock Server Configuration:")+"&lt/backend.mock.application.configurer.port&gt"+
                "<br>"+
                "&ltbackend.mock.application.port&gt"+getPortString(text, "AS Portal UI:")+"&lt/backend.mock.application.port&gt"+
                "<br>"+
                "&ltbackend.mock.as2.service.port&gt"+getPortString(text, "AS Backend:") +"&lt/backend.mock.as2.service.port&gt"+
                "<br>"+
                "&ltbackend.mock.as2.service.internal.port&gt"+getPortString(text, "AS Backend Internal:")+"&lt/backend.mock.as2.service.internal.port&gt"+
                "<br>"+
                "&ltbackend.mock.admin.ui.port&gt"+getPortString(text, "WPP Admin Portal UI:")+"&lt/backend.mock.admin.ui.port&gt"+
                "<br>"+
                "&ltbackend.mock.admin.port&gt"+getPortString(text, "WPP Admin Backend:")+"&lt/backend.mock.admin.port&gt"+
                "<br>"+
                "&ltbackend.mock.auth.service.port&gt"+getPortString(text, "Authentication Service:")+"&lt/backend.mock.auth.service.port&gt"+
                "<br>"+
                "&ltbackend.mock.notification.service.port&gt"+getPortString(text, "Notification Service:")+"&lt/backend.mock.notification.service.port&gt"+
                "<br>"+
                "&ltbackend.mock.orderservice.service.port&gt16552&lt/backend.mock.orderservice.service.port&gt"+
                "<br>"+
                "&ltbackend.mock.wpp.product.service.port&gt"+getPortString(text, "Product Service:")+"&lt/backend.mock.wpp.product.service.port&gt"+
                "<br>"+
                "&ltbackend.mock.participant.port&gt"+getPortString(text, "Participants Service:")+"&lt/backend.mock.participant.port&gt"+
                "<br>"+
                "&ltbackend.mock.funder.dashboard.port&gt"+getPortString(text, "Funder Dashboard:")+"&lt/backend.mock.funder.dashboard.port&gt"+
                "<br>"+
                "&ltbackend.mock.funder.dashboard.ui.port&gt"+getPortString(text, "Funder Dashboard UI:")+"&lt/backend.mock.funder.dashboard.ui.port&gt"+
                "<br>"+
                "&ltbackend.mock.activiti.bpm.port&gt"+getPortString(text, "AS BPM:")+"&lt/backend.mock.activiti.bpm.port&gt"+
                "<br>"+
                "&ltbackend.mock.aws.s3.port&gt"+getPortString(text, "AWS S3 Server:")+"&lt/backend.mock.aws.s3.port&gt"+
                "<br>"+
                "&ltbackend.mock.ftp.port&gt"+getPortString(text, "EM FTP Server:")+"&lt/backend.mock.ftp.port&gt"+
                "<br>"+
                "&ltrun.tests.on&gtbackend-mock&lt/run.tests.on&gt"+

                "</body>" +
                "</html>";
    }

    private String getPortString(String text, String fieldName) {
//        String tempString = text;
        int startIndex = text.indexOf(fieldName);
        if (startIndex == -1) return "not valid input data string";
        String subString = text.substring(startIndex + fieldName.length()).trim();
        int i = 0;
        char c = subString.charAt(i);
        String result = "";
        while (Character.isDigit(c)) {
            result = result + c;
            c = subString.charAt(++i);
        }
        try {
            Integer.parseInt(result);
        } catch (NumberFormatException e) {
            System.out.println("Failed port parsing for " + fieldName + " on substring=" + result);
            return result = "error parsing";
        }
        return result;
    }
}
