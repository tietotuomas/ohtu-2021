/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

public class QueryBuilder {

    Matcher matcher;

    public QueryBuilder() {
        matcher = new All();
    }

    public Matcher build() {
        Matcher built = this.matcher;
        this.matcher = new All();
        return built;
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new And(this.matcher, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new And(this.matcher, new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new And(this.matcher, new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher first, Matcher second) {
        this.matcher = new And(new Or(first, second));
        return this;
    }
}
