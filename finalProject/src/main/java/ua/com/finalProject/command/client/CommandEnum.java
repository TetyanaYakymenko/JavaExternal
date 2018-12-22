package ua.com.finalProject.command.client;

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
    }
    ;
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
    }

