package controllers;

import entities.Account;
import entities.GrantAccess;
import entities.Log;
import entities.Role;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.AccountRep;
import repositories.GrantAccessRep;
import repositories.LogRep;
import repositories.RoleRep;

import java.io.IOException;

@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {
    private AccountRep accountService = new AccountRep();
    private RoleRep roleService = new RoleRep();
    private GrantAccessRep grantAccessService = new GrantAccessRep();
    private LogRep logService = new LogRep();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String entity = request.getParameter("entity");  // Lấy thông tin entity

        if (entity == null || action == null) {
            response.getWriter().write("Missing parameters.");
            return;
        }

        switch (entity) {
            case "account":
                handleAccountAction(action, request, response);
                break;
            case "role":
                handleRoleAction(action, request, response);
                break;
            case "grantAccess":
                handleGrantAccessAction(action, request, response);
                break;
            case "log":
                handleLogAction(action, request, response);
                break;
            default:
                response.getWriter().write("Invalid entity.");
        }
    }

    private void handleAccountAction(String action, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if ("add".equals(action)) {
            Account account = new Account();
            account.setAccount_id(request.getParameter("account_id"));
            account.setFull_name(request.getParameter("full_name"));
            account.setPassword(request.getParameter("password"));
            account.setEmail(request.getParameter("email"));
            account.setPhone(request.getParameter("phone"));
            account.setStatus(Integer.parseInt(request.getParameter("status")));
            accountService.addAccount(account);
            response.getWriter().write("Account added successfully.");
        } else if ("update".equals(action)) {
            String accountId = request.getParameter("account_id");
            Account account = accountService.getAccount(accountId);

            if (account != null) {
                account.setFull_name(request.getParameter("full_name"));
                account.setPassword(request.getParameter("password"));
                account.setEmail(request.getParameter("email"));
                account.setPhone(request.getParameter("phone"));
                account.setStatus(Integer.parseInt(request.getParameter("status")));

                accountService.updateAccount(account); // Thực hiện cập nhật trong DB
                response.getWriter().write("Account updated successfully.");
            } else {
                response.getWriter().write("Account not found.");
            }
        } else if ("delete".equals(action)) {
            String accountId = request.getParameter("account_id");
            accountService.deleteAccount(accountId);
            response.getWriter().write("Account deleted successfully.");
        } else {
            response.getWriter().write("Invalid account action.");
        }
    }

    private void handleRoleAction(String action, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if ("add".equals(action)) {
            Role role = new Role();
            role.setRole_id(request.getParameter("role_id"));
            role.setRole_name(request.getParameter("role_name"));
            role.setRole_description(request.getParameter("description"));
            role.setStatus(Integer.parseInt(request.getParameter("status")));
            roleService.addRole(role);
            response.getWriter().write("Role added successfully.");
        } else if ("update".equals(action)) {

        } else if ("delete".equals(action)) {
            String roleId = request.getParameter("role_id");
            roleService.deleteRole(roleId);
            response.getWriter().write("Role deleted successfully.");
        } else {
            response.getWriter().write("Invalid role action.");
        }
    }

    private void handleGrantAccessAction(String action, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if ("add".equals(action)) {

            response.getWriter().write("GrantAccess added successfully.");
        } else if ("update".equals(action)) {

        } else if ("delete".equals(action)) {

        }

    }

    private void handleLogAction(String action, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if ("add".equals(action)) {
            Log log = new Log();
            log.setAccount_id(request.getParameter("account_id"));
            log.setLogin_time(java.sql.Timestamp.valueOf(request.getParameter("login_time")));
            log.setLogout_time(java.sql.Timestamp.valueOf(request.getParameter("logout_time")));
            log.setNotes(request.getParameter("notes"));
            logService.addLog(log);
            response.getWriter().write("Log added successfully.");
        } else if ("update".equals(action)) {

        } else if ("delete".equals(action)) {
            Long id = Long.parseLong(request.getParameter("id"));
            logService.deleteLog(id);
            response.getWriter().write("Log deleted successfully.");
        } else {
            response.getWriter().write("Invalid log action.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
