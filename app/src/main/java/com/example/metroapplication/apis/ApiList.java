package com.example.metroapplication.apis;


public class ApiList {
    public static final String BaseURL="http://serverIP:port/api/";

    public static final String RouteListURL = BaseURL+"getMasterData";
    public static final String loginAPI = BaseURL+"customerLogin";

    public static final String registration = BaseURL+"userRegistration";
    public static final String changePassword = BaseURL+"userPasswordReset";

    public static final String ticketResponseAPI = BaseURL+"userTickets";

    public static final String routenamedetails = BaseURL+"getTransMasterData";
    public static final String bookticketURL1 = BaseURL+"bookQRTicket";

    public static final String modifyTicket = BaseURL+"modifyQRTicket";

    public static final String panelty_response = BaseURL+"userTickets";
    public static final String QrCashResponseApi = BaseURL+"bookQRTicketByCash";
    public static final String ShowResponseOfValueQR = BaseURL+"userTickets";
}
