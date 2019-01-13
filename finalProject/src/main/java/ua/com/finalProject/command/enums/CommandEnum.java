package ua.com.finalProject.command.enums;

import ua.com.finalProject.command.*;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    MAIN {
        {
            this.command = new MainCommand();
        }
    },
    ADMIN {
        {
            this.command = new AdminCommand();
        }
    },
    EDIT {
        {
            this.command = new EditCommand();
        }
    },
    LANGUAGE {
        {
            this.command = new LanguageCommand();
        }
    },
    REGISTER {
        {
            this.command = new RegisterCommand();
        }
    },
    MAIL {
        {
            this.command = new EmailCommand();
        }
    },
    REPORTS {
        {
            this.command = new ReportsCommand();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}

