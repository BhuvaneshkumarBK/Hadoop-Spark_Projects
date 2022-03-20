/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.acme.avro;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class public_metrics extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6152904322290602121L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"public_metrics\",\"namespace\":\"com.acme.avro\",\"fields\":[{\"name\":\"retweet_count\",\"type\":\"int\"},{\"name\":\"reply_count\",\"type\":\"int\"},{\"name\":\"like_count\",\"type\":\"int\"},{\"name\":\"quote_count\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int retweet_count;
  @Deprecated public int reply_count;
  @Deprecated public int like_count;
  @Deprecated public int quote_count;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public public_metrics() {}

  /**
   * All-args constructor.
   * @param retweet_count The new value for retweet_count
   * @param reply_count The new value for reply_count
   * @param like_count The new value for like_count
   * @param quote_count The new value for quote_count
   */
  public public_metrics(Integer retweet_count, Integer reply_count, Integer like_count, Integer quote_count) {
    this.retweet_count = retweet_count;
    this.reply_count = reply_count;
    this.like_count = like_count;
    this.quote_count = quote_count;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return retweet_count;
    case 1: return reply_count;
    case 2: return like_count;
    case 3: return quote_count;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: retweet_count = (Integer)value$; break;
    case 1: reply_count = (Integer)value$; break;
    case 2: like_count = (Integer)value$; break;
    case 3: quote_count = (Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'retweet_count' field.
   * @return The value of the 'retweet_count' field.
   */
  public Integer getRetweetCount() {
    return retweet_count;
  }

  /**
   * Sets the value of the 'retweet_count' field.
   * @param value the value to set.
   */
  public void setRetweetCount(Integer value) {
    this.retweet_count = value;
  }

  /**
   * Gets the value of the 'reply_count' field.
   * @return The value of the 'reply_count' field.
   */
  public Integer getReplyCount() {
    return reply_count;
  }

  /**
   * Sets the value of the 'reply_count' field.
   * @param value the value to set.
   */
  public void setReplyCount(Integer value) {
    this.reply_count = value;
  }

  /**
   * Gets the value of the 'like_count' field.
   * @return The value of the 'like_count' field.
   */
  public Integer getLikeCount() {
    return like_count;
  }

  /**
   * Sets the value of the 'like_count' field.
   * @param value the value to set.
   */
  public void setLikeCount(Integer value) {
    this.like_count = value;
  }

  /**
   * Gets the value of the 'quote_count' field.
   * @return The value of the 'quote_count' field.
   */
  public Integer getQuoteCount() {
    return quote_count;
  }

  /**
   * Sets the value of the 'quote_count' field.
   * @param value the value to set.
   */
  public void setQuoteCount(Integer value) {
    this.quote_count = value;
  }

  /**
   * Creates a new public_metrics RecordBuilder.
   * @return A new public_metrics RecordBuilder
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Creates a new public_metrics RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new public_metrics RecordBuilder
   */
  public static Builder newBuilder(Builder other) {
    return new Builder(other);
  }

  /**
   * Creates a new public_metrics RecordBuilder by copying an existing public_metrics instance.
   * @param other The existing instance to copy.
   * @return A new public_metrics RecordBuilder
   */
  public static Builder newBuilder(public_metrics other) {
    return new Builder(other);
  }

  /**
   * RecordBuilder for public_metrics instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<public_metrics>
    implements org.apache.avro.data.RecordBuilder<public_metrics> {

    private int retweet_count;
    private int reply_count;
    private int like_count;
    private int quote_count;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.retweet_count)) {
        this.retweet_count = data().deepCopy(fields()[0].schema(), other.retweet_count);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.reply_count)) {
        this.reply_count = data().deepCopy(fields()[1].schema(), other.reply_count);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.like_count)) {
        this.like_count = data().deepCopy(fields()[2].schema(), other.like_count);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.quote_count)) {
        this.quote_count = data().deepCopy(fields()[3].schema(), other.quote_count);
        fieldSetFlags()[3] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing public_metrics instance
     * @param other The existing instance to copy.
     */
    private Builder(public_metrics other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.retweet_count)) {
        this.retweet_count = data().deepCopy(fields()[0].schema(), other.retweet_count);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.reply_count)) {
        this.reply_count = data().deepCopy(fields()[1].schema(), other.reply_count);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.like_count)) {
        this.like_count = data().deepCopy(fields()[2].schema(), other.like_count);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.quote_count)) {
        this.quote_count = data().deepCopy(fields()[3].schema(), other.quote_count);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'retweet_count' field.
      * @return The value.
      */
    public Integer getRetweetCount() {
      return retweet_count;
    }

    /**
      * Sets the value of the 'retweet_count' field.
      * @param value The value of 'retweet_count'.
      * @return This builder.
      */
    public Builder setRetweetCount(int value) {
      validate(fields()[0], value);
      this.retweet_count = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'retweet_count' field has been set.
      * @return True if the 'retweet_count' field has been set, false otherwise.
      */
    public boolean hasRetweetCount() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'retweet_count' field.
      * @return This builder.
      */
    public Builder clearRetweetCount() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'reply_count' field.
      * @return The value.
      */
    public Integer getReplyCount() {
      return reply_count;
    }

    /**
      * Sets the value of the 'reply_count' field.
      * @param value The value of 'reply_count'.
      * @return This builder.
      */
    public Builder setReplyCount(int value) {
      validate(fields()[1], value);
      this.reply_count = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'reply_count' field has been set.
      * @return True if the 'reply_count' field has been set, false otherwise.
      */
    public boolean hasReplyCount() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'reply_count' field.
      * @return This builder.
      */
    public Builder clearReplyCount() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'like_count' field.
      * @return The value.
      */
    public Integer getLikeCount() {
      return like_count;
    }

    /**
      * Sets the value of the 'like_count' field.
      * @param value The value of 'like_count'.
      * @return This builder.
      */
    public Builder setLikeCount(int value) {
      validate(fields()[2], value);
      this.like_count = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'like_count' field has been set.
      * @return True if the 'like_count' field has been set, false otherwise.
      */
    public boolean hasLikeCount() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'like_count' field.
      * @return This builder.
      */
    public Builder clearLikeCount() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'quote_count' field.
      * @return The value.
      */
    public Integer getQuoteCount() {
      return quote_count;
    }

    /**
      * Sets the value of the 'quote_count' field.
      * @param value The value of 'quote_count'.
      * @return This builder.
      */
    public Builder setQuoteCount(int value) {
      validate(fields()[3], value);
      this.quote_count = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'quote_count' field has been set.
      * @return True if the 'quote_count' field has been set, false otherwise.
      */
    public boolean hasQuoteCount() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'quote_count' field.
      * @return This builder.
      */
    public Builder clearQuoteCount() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public public_metrics build() {
      try {
        public_metrics record = new public_metrics();
        record.retweet_count = fieldSetFlags()[0] ? this.retweet_count : (Integer) defaultValue(fields()[0]);
        record.reply_count = fieldSetFlags()[1] ? this.reply_count : (Integer) defaultValue(fields()[1]);
        record.like_count = fieldSetFlags()[2] ? this.like_count : (Integer) defaultValue(fields()[2]);
        record.quote_count = fieldSetFlags()[3] ? this.quote_count : (Integer) defaultValue(fields()[3]);
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
