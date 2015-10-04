package com.raizlabs.android.dbflow.sql.language.property;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.BaseModelQueriable;
import com.raizlabs.android.dbflow.sql.language.Condition;
import com.raizlabs.android.dbflow.sql.language.ITypeConditional;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.structure.Model;

import static com.raizlabs.android.dbflow.sql.language.Condition.column;

/**
 * Description: Basic {@link byte} property. Accepts only byte, {@link BaseModelQueriable}, and
 * {@link ITypeConditional} objects.
 */
public class ByteProperty extends BaseProperty<ByteProperty> {

    public ByteProperty(Class<? extends Model> table, NameAlias nameAlias) {
        super(table, nameAlias);
    }

    public ByteProperty(Class<? extends Model> table, String columnName) {
        this(table, new NameAlias(columnName));
    }

    public ByteProperty(Class<? extends Model> table, String columnName, String aliasName) {
        this(table, new NameAlias(columnName, aliasName));
    }

    @Override
    public ByteProperty as(String aliasName) {
        return new ByteProperty(table, nameAlias.getAliasNameRaw(), aliasName);
    }

    @Override
    public ByteProperty distinct() {
        return new ByteProperty(table, getDistinctAliasName());
    }

    @Override
    public ByteProperty withTable() {
        return withTable(new NameAlias(FlowManager.getTableName(table)));
    }

    @Override
    public ByteProperty withTable(NameAlias tableNameAlias) {
        NameAlias alias = new NameAlias(tableNameAlias.getAliasName() + "." + nameAlias.getName(), nameAlias.getAliasName());
        alias.tickName(false);
        return new ByteProperty(table, alias);
    }

    public Condition is(byte value) {
        return column(nameAlias).is(value);
    }

    public Condition eq(byte value) {
        return column(nameAlias).eq(value);
    }

    public Condition isNot(byte value) {
        return column(nameAlias).isNot(value);
    }

    public Condition notEq(byte value) {
        return column(nameAlias).notEq(value);
    }

    public Condition like(byte value) {
        return column(nameAlias).like(value);
    }

    public Condition glob(byte value) {
        return column(nameAlias).glob(value);
    }

    public Condition greaterThan(byte value) {
        return column(nameAlias).greaterThan(value);
    }

    public Condition greaterThanOrEq(byte value) {
        return column(nameAlias).greaterThanOrEq(value);
    }

    public Condition lessThan(byte value) {
        return column(nameAlias).lessThan(value);
    }

    public Condition lessThanOrEq(byte value) {
        return column(nameAlias).lessThanOrEq(value);
    }

    public Condition.Between between(byte value) {
        return column(nameAlias).between(value);
    }

    public Condition.In in(byte firstValue, byte... values) {
        Condition.In in = column(nameAlias).in(firstValue);
        for (byte value : values) {
            in.and(value);
        }
        return in;
    }

    public Condition.In notIn(byte firstValue, byte... values) {
        Condition.In in = column(nameAlias).notIn(firstValue);
        for (byte value : values) {
            in.and(value);
        }
        return in;
    }

    public Condition concatenate(byte value) {
        return column(nameAlias).concatenate(value);
    }
}