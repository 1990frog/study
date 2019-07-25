package hadoop.mapreduce.access;

import lombok.Getter;
import lombok.Setter;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * 自定义复杂数据类型
 * 按照hadoop规范，要实现Writable方法
 * 实现write和readFields这两个方法
 * 定义一个默认的构造方法
 */
@Setter
@Getter
public class Access implements Writable {

	private String phone;
	private Long up;
	private Long down;
	private Long sum;

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(phone);
		out.writeLong(up);
		out.writeLong(down);
		out.writeLong(sum);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		this.phone=in.readUTF();
		this.up=in.readLong();
		this.down=in.readLong();
		this.sum=in.readLong();
	}

	public Access() {
	}

	public Access(String phone, Long up, Long down) {
		this.phone = phone;
		this.up = up;
		this.down = down;
		this.sum = up + down;
	}

	@Override
	public String toString() {
		return "Access{" +
				"phone='" + phone + '\'' +
				", up=" + up +
				", down=" + down +
				", sum=" + sum +
				'}';
	}
}
