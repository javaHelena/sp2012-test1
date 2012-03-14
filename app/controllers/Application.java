package controllers;

import models.Comment;
import play.data.Form;
import play.mvc.*;

public class Application extends Controller {

    static Form<Comment> commentForm = form(Comment.class);

    public static Result index() {
        return ok(views.html.index.render(Comment.all(), commentForm));
    }

    public static Result comments() {
        return ok(views.html.index.render(Comment.all(), commentForm));
    }


    public static Result addComment() {
        Form<Comment> filledForm = commentForm.bindFromRequest();

        if (filledForm.hasErrors()) {
            return badRequest(
                    views.html.index.render(Comment.all(), filledForm)
            );
        } else {
            Comment.create(filledForm.get());
            return redirect(routes.Application.index());
        }

    }


}