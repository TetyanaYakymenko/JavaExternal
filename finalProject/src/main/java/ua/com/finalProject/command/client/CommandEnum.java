package ua.com.finalProject.command.client;

import ua.com.finalProject.command.ActionCommand;
import ua.com.finalProject.command.LoginCommand;
import ua.com.finalProject.command.LogoutCommand;

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
        };
        ActionCommand command;
        public ActionCommand getCurrentCommand() {
            return command;
        }
    }

