package ltst.org.attribute.info.typeannotation.typepath;

import ltst.org.classfile.ClassReader;

/**
 * type_path {
 *     u1 path_length;
 *     {
 *         u1 type_path_kind;
 *         u1 type_argument_index;
 *     } path[[path_length]
 * }
 */
public class TypePath {
    public byte pathLength;
    public PathInfo[] path;
    public TypePath(ClassReader cr){
        this.pathLength = cr.readU1();
        this.path = new PathInfo[cr.readU1()];
        for (int i = 0; i < this.path.length; i++) {
            this.path[i] = new PathInfo(cr);
        }
    }
}
