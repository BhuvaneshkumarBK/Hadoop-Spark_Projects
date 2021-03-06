/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.acme.avro;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class countStore extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6127036880996177797L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"countStore\",\"namespace\":\"com.acme.avro\",\"fields\":[{\"name\":\"tag\",\"type\":\"string\"},{\"name\":\"count\",\"type\":\"long\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence tag;
  @Deprecated public long count;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public countStore() {}

  /**
   * All-args constructor.
   * @param tag The new value for tag
   * @param count The new value for count
   */
  public countStore(java.lang.CharSequence tag, java.lang.Long count) {
    this.tag = tag;
    this.count = count;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return tag;
    case 1: return count;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: tag = (java.lang.CharSequence)value$; break;
    case 1: count = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'tag' field.
   * @return The value of the 'tag' field.
   */
  public java.lang.CharSequence getTag() {
    return tag;
  }

  /**
   * Sets the value of the 'tag' field.
   * @param value the value to set.
   */
  public void setTag(java.lang.CharSequence value) {
    this.tag = value;
  }

  /**
   * Gets the value of the 'count' field.
   * @return The value of the 'count' field.
   */
  public java.lang.Long getCount() {
    return count;
  }

  /**
   * Sets the value of the 'count' field.
   * @param value the value to set.
   */
  public void setCount(java.lang.Long value) {
    this.count = value;
  }

  /**
   * Creates a new countStore RecordBuilder.
   * @return A new countStore RecordBuilder
   */
  public static com.acme.avro.countStore.Builder newBuilder() {
    return new com.acme.avro.countStore.Builder();
  }

  /**
   * Creates a new countStore RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new countStore RecordBuilder
   */
  public static com.acme.avro.countStore.Builder newBuilder(com.acme.avro.countStore.Builder other) {
    return new com.acme.avro.countStore.Builder(other);
  }

  /**
   * Creates a new countStore RecordBuilder by copying an existing countStore instance.
   * @param other The existing instance to copy.
   * @return A new countStore RecordBuilder
   */
  public static com.acme.avro.countStore.Builder newBuilder(com.acme.avro.countStore other) {
    return new com.acme.avro.countStore.Builder(other);
  }

  /**
   * RecordBuilder for countStore instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<countStore>
    implements org.apache.avro.data.RecordBuilder<countStore> {

    private java.lang.CharSequence tag;
    private long count;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.acme.avro.countStore.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.tag)) {
        this.tag = data().deepCopy(fields()[0].schema(), other.tag);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.count)) {
        this.count = data().deepCopy(fields()[1].schema(), other.count);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing countStore instance
     * @param other The existing instance to copy.
     */
    private Builder(com.acme.avro.countStore other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.tag)) {
        this.tag = data().deepCopy(fields()[0].schema(), other.tag);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.count)) {
        this.count = data().deepCopy(fields()[1].schema(), other.count);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'tag' field.
      * @return The value.
      */
    public java.lang.CharSequence getTag() {
      return tag;
    }

    /**
      * Sets the value of the 'tag' field.
      * @param value The value of 'tag'.
      * @return This builder.
      */
    public com.acme.avro.countStore.Builder setTag(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.tag = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'tag' field has been set.
      * @return True if the 'tag' field has been set, false otherwise.
      */
    public boolean hasTag() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'tag' field.
      * @return This builder.
      */
    public com.acme.avro.countStore.Builder clearTag() {
      tag = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'count' field.
      * @return The value.
      */
    public java.lang.Long getCount() {
      return count;
    }

    /**
      * Sets the value of the 'count' field.
      * @param value The value of 'count'.
      * @return This builder.
      */
    public com.acme.avro.countStore.Builder setCount(long value) {
      validate(fields()[1], value);
      this.count = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'count' field has been set.
      * @return True if the 'count' field has been set, false otherwise.
      */
    public boolean hasCount() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'count' field.
      * @return This builder.
      */
    public com.acme.avro.countStore.Builder clearCount() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public countStore build() {
      try {
        countStore record = new countStore();
        record.tag = fieldSetFlags()[0] ? this.tag : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.count = fieldSetFlags()[1] ? this.count : (java.lang.Long) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
