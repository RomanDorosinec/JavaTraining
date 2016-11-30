package by.dorosinec.traning.phonebook.app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ManagePersonServlet extends HttpServlet {

    // ID for serialization / deserialization.
    private static final long serialVersionUID = 1L;
    private Phonebook phonebook;

    /**
     * Constructor that calls the superclass. Creates a copy of the phone book
     */
    public ManagePersonServlet() {
        super();
        try {
            this.phonebook = Phonebook.getInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Validation Name and generating an error message in the event of non-valid data.
     *
     * @param person object of class person
     * @return message of error, if it exist
     */
    private String validatePersonFMLName(Person person) {
        String error_message = "";

        if (!person.validateFMLNamePart(person.getName(), false)) {
            error_message += "Имя должно быть строкой от 1 до 150 символов из букв, цифр, знаков подчёркивания и знаков минус.<br />";
        }

        if (!person.validateFMLNamePart(person.getSurname(), false)) {
            error_message += "Фамилия должна быть строкой от 1 до 150 символов из букв, цифр, знаков подчёркивания и знаков минус.<br />";
        }

        if (!person.validateFMLNamePart(person.getMiddlename(), true)) {
            error_message += "Отчество должно быть строкой от 0 до 150 символов из букв, цифр, знаков подчёркивания и знаков минус.<br />";
        }

        return error_message;
    }

    /**
     * Reaction to the GET-requests.
     *
     * @param request  http servlet request
     * @param response http servlet response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("phonebook", this.phonebook);
        HashMap<String, String> jsp_parameters = new HashMap<String, String>();

        // Managers to transfer control to different JSP (different views (view)).
        RequestDispatcher dispatcher_for_manager = request.getRequestDispatcher("/ManagePerson.jsp");
        RequestDispatcher dispatcher_for_list = request.getRequestDispatcher("/List.jsp");
        RequestDispatcher dispatcher_for_managePhone = request.getRequestDispatcher("/ManagePhone");

        // Action (action) and the record identifier (id) on which to perform this action.
        String action = request.getParameter("action");
        String id = request.getParameter("id");

        /**
         * If the ID and the action is not listed, we are able to "just show the list, and do nothing else.
         */
        if ((action == null) && (id == null)) {
            request.setAttribute("jsp_parameters", jsp_parameters);
            dispatcher_for_list.forward(request, response);
        } else {
            switch (action) {
                // Adding an entry.
                case "add":
                    Person empty_person = new Person();
                    // Preparing the parameters for the JSP.
                    jsp_parameters.put("current_action", "add");
                    jsp_parameters.put("next_action", "add_go");
                    jsp_parameters.put("next_action_label", "Добавить");
                    // Installation JSP parameters.
                    request.setAttribute("person", empty_person);
                    request.setAttribute("jsp_parameters", jsp_parameters);
                    // Transfer request to the JSP.
                    dispatcher_for_manager.forward(request, response);
                    break;

                // Editing records.
                case "edit":
                    Person editable_person = this.phonebook.getPerson(id);
                    // Preparing the parameters for the JSP.
                    jsp_parameters.put("current_action", "edit");
                    jsp_parameters.put("next_action", "edit_go");
                    jsp_parameters.put("next_action_label", "Сохранить");
                    // Installation JSP parameters.
                    request.setAttribute("person", editable_person);
                    request.setAttribute("jsp_parameters", jsp_parameters);
                    // Transfer request to the JSP.
                    dispatcher_for_manager.forward(request, response);
                    break;

                // Deleting records.
                case "delete":
                    if (phonebook.deletePerson(id)) {
                        jsp_parameters.put("current_action_result", "DELETION_SUCCESS");
                        jsp_parameters.put("current_action_result_label", "Удаление выполнено успешно");
                    } else {
                        jsp_parameters.put("current_action_result", "DELETION_FAILURE");
                        jsp_parameters.put("current_action_result_label", "Ошибка удаления (возможно, запись не найдена)");
                    }
                    //Installation JSP parameters.
                    request.setAttribute("jsp_parameters", jsp_parameters);
                    //Transfer request to the JSP.
                    dispatcher_for_list.forward(request, response);
                    break;

                /*case "pid":
                    Person redact_person = this.phonebook.getPerson(id);
                    jsp_parameters.put("current_action", "edit");
                    jsp_parameters.put("next_action", "edit_go");
                    jsp_parameters.put("next_action_label", "Сохранить");

                    // Установка параметров JSP.
                    request.setAttribute("person", redact_person);
                    request.setAttribute("jsp_parameters", jsp_parameters);

                    // Передача запроса в JSP.
                    dispatcher_for_managePhone.forward(request, response);
                    break;*/
            }
        }

    }

    /**
     * The response to the POST-request.
     *
     * @param request  http servlet request
     * @param response http servlet response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("phonebook", this.phonebook);
        HashMap<String, String> jsp_parameters = new HashMap<String, String>();

        // Managers to transfer control to different JSP (different views (view)).
        RequestDispatcher dispatcher_for_manager = request.getRequestDispatcher("/ManagePerson.jsp");
        RequestDispatcher dispatcher_for_list = request.getRequestDispatcher("/List.jsp");
        RequestDispatcher dispatcher_for_managePhone = request.getRequestDispatcher("/ManagePhone");


        // Action (add_go, edit_go) and records the identifier (id) on which to perform this action.
        String add_go = request.getParameter("add_go");
        String edit_go = request.getParameter("edit_go");
        String id = request.getParameter("id");

        // Adding entries.
        if (add_go != null) {
            Person new_person = new Person(request.getParameter("name"), request.getParameter("surname"), request.getParameter("middlename"));
            String error_message = this.validatePersonFMLName(new_person);

            // If the data is correct, it is possible to make the addition.
            if (error_message.equals("")) {

                // If the record could add ...
                if (this.phonebook.addPerson(new_person)) {
                    jsp_parameters.put("current_action_result", "ADDITION_SUCCESS");
                    jsp_parameters.put("current_action_result_label", "Добавление выполнено успешно");
                }
                // If the record could not be added
                else {
                    jsp_parameters.put("current_action_result", "ADDITION_FAILURE");
                    jsp_parameters.put("current_action_result_label", "Ошибка добавления");
                }
                request.setAttribute("jsp_parameters", jsp_parameters);
                dispatcher_for_list.forward(request, response);
            }
            // If the data have been mistakes, it is necessary to re-display the form and report bugs.
            else {
                // Preparing the parameters for the JSP.
                jsp_parameters.put("current_action", "add");
                jsp_parameters.put("next_action", "add_go");
                jsp_parameters.put("next_action_label", "Добавить");
                jsp_parameters.put("error_message", error_message);

                // Installation JSP parameters.
                request.setAttribute("person", new_person);
                request.setAttribute("jsp_parameters", jsp_parameters);

                // Transfer request to the JSP.
                dispatcher_for_manager.forward(request, response);
            }
        }

        // Editing the entry.
        if (edit_go != null) {
            // Preparation of recording and updating it based on the data from the form.
            Person updatable_person = this.phonebook.getPerson(request.getParameter("id"));
            updatable_person.setName(request.getParameter("name"));
            updatable_person.setSurname(request.getParameter("surname"));
            updatable_person.setMiddlename(request.getParameter("middlename"));

            String error_message = this.validatePersonFMLName(updatable_person);

            // If the data is correct, it is possible to make the addition.
            if (error_message.equals("")) {

                // If the record could add ...
                if (this.phonebook.updatePerson(id, updatable_person)) {
                    jsp_parameters.put("current_action_result", "UPDATE_SUCCESS");
                    jsp_parameters.put("current_action_result_label", "Обновление выполнено успешно");
                }
                // If the record could not be added
                else {
                    jsp_parameters.put("current_action_result", "UPDATE_FAILURE");
                    jsp_parameters.put("current_action_result_label", "Ошибка обновления");
                }
                request.setAttribute("jsp_parameters", jsp_parameters);
                dispatcher_for_list.forward(request, response);
            }
            // If the data have been mistakes, it is necessary to re-display the form and report bugs.
            else {
                // Preparing the parameters for the JSP.
                jsp_parameters.put("current_action", "edit");
                jsp_parameters.put("next_action", "edit_go");
                jsp_parameters.put("next_action_label", "Сохранить");
                jsp_parameters.put("error_message", error_message);

                // Installation JSP parameters.
                request.setAttribute("person", updatable_person);
                request.setAttribute("jsp_parameters", jsp_parameters);

                // Transfer request to the JSP.
                dispatcher_for_manager.forward(request, response);
            }
        }
    }
}
